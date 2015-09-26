package by.agency.travel.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import by.agency.travel.entity.Role;
import by.agency.travel.entity.User;
import by.agency.travel.hibernate.dao.AbstractDao;
import by.agency.travel.hibernate.dao.UserDao;
import by.agency.travel.hibernate.dao.exception.DaoException;
import by.agency.travel.hibernate.dao.pojos.RolePojo;
import by.agency.travel.hibernate.dao.pojos.UserPojo;

public class UserDaoImpl extends AbstractDao<User, UserPojo> implements UserDao{
	private static UserDaoImpl instance;
	private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	private final String HQL= "SELECT u FROM UserPojo AS u WHERE u.login=:userLogin AND u.pass=:userPassword ";
	
	private UserDaoImpl(){
	}
	
	public synchronized static UserDaoImpl getInstance(){
		LOGGER.debug("Run getInstance method");
		if(instance == null){
			instance = new UserDaoImpl();
		}
		return instance;
	}

	@Override
	protected Class<UserPojo> getPersistentClass() {
		return UserPojo.class;
	}

	@Override
	protected UserPojo transformEntityToPojo(User entity) {
		List<RolePojo> roles = new ArrayList<>();
		for(Role role : entity.getRoles()){
			RolePojo rolePojo = new RolePojo();
			rolePojo.setId(role.getId());
			rolePojo.setName(role.getName());
			roles.add(rolePojo);
		}
		UserPojo pojo = new UserPojo(entity.getId(), entity.getLogin(), entity.getPass(), roles);
		return pojo;
	}

	@Override
	protected User transformPojoToEntity(UserPojo pojo) {
		List<Role> roles = new ArrayList<>();
		for(RolePojo rolePojo : pojo.getRoles()){
			Role role = new Role();
			role.setId(rolePojo.getId());
			role.setName(rolePojo.getName());
			roles.add(role);
		}
		User user = new User(pojo.getId(), pojo.getLogin(), pojo.getPass(), roles);
		return user;
	}

	@Override
	public User getByLoginAndPass(String login, String pass) throws DaoException{
		LOGGER.debug("Run method getByLoginAndPass login: " + login);
		Session session = null;
		Transaction transaction = null;
		User entity = null;
		try{
			session = super.getSessionFactory().openSession();
			LOGGER.debug("Session is open");
			transaction = session.beginTransaction();
			LOGGER.debug("Transaction is begin");
			Query query = session.createQuery(HQL);
			query.setParameter("userLogin", login);
			query.setParameter("userPassword", pass);
			List<UserPojo> results = query.list();
			for(UserPojo pojo : results){
				entity = transformPojoToEntity(pojo);
				LOGGER.debug("Pojo is transform in entity");
			}
			LOGGER.debug("User is get");
			transaction.commit();
			LOGGER.debug("Transaction is commit");
		} catch(HibernateException e){
			LOGGER.error("Cannot get login= " + login, e);
			transaction.rollback();
			throw new DaoException("Cannot get login= " + login, e);
		} finally{
			closeSession(session);
		}
		LOGGER.debug("Get method is complete");
		return entity;
	}

	private void closeSession(Session session){
		if (session != null && session.isOpen()) {
			session.close();
        LOGGER.debug("Session is close");
      }
}
}