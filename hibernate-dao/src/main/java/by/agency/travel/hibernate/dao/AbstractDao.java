package by.agency.travel.hibernate.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import by.agency.travel.hibernate.dao.exception.DaoException;

public abstract class AbstractDao<E, P extends Serializable> implements GenericDao<E>{
	private static final Logger LOGGER = Logger.getLogger(AbstractDao.class);
	private SessionFactory sessionFactory;
	
	protected SessionFactory getSessionFactory() throws DaoException {
        if (sessionFactory == null) {
            LOGGER.error("Cannot configured DAO. SessionFactory is not submitted");
            throw new DaoException("Cannot configured DAO. SessionFactory is not submitted");
        }
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public Integer create(E entity) throws DaoException {
		LOGGER.debug("Creating new object= " + entity);
		P pojo = transformEntityToPojo(entity);
		Session session = null;
		Transaction transaction = null;
		Integer id;
		try{
			session = getSessionFactory().openSession();
			LOGGER.debug("Session is open");
			transaction = session.beginTransaction();
			LOGGER.debug("Transaction is begin");
			id = (Integer) session.save(pojo);
			LOGGER.debug("Object is save");
			transaction.commit();
			LOGGER.debug("Transaction is commit");
		} catch(HibernateException e){
			LOGGER.error("Cannot create " + entity, e);
			transaction.rollback();
			throw new DaoException("Cannot create " + entity, e);
		} finally{
			closeSession(session);
		}
		LOGGER.debug("Create method is complete, object=" + entity);
		return id;
	}

	@Override
	public E read(Integer id) throws DaoException {
		LOGGER.debug("Getting object by key=" + id);
		E entity;
		Session session = null;
		Transaction transaction = null;
		try{
			session = getSessionFactory().openSession();
			LOGGER.debug("Session is open");
			transaction = session.beginTransaction();
			LOGGER.debug("Transaction is begin");
			P pojo = (P) session.get(getPersistentClass(), id);
			LOGGER.debug("Object is get");
			transaction.commit();
			LOGGER.debug("Transaction is commit");
			entity = transformPojoToEntity(pojo);
			LOGGER.debug("Pojo is transform in entity");
		} catch(HibernateException e){
			LOGGER.error("Cannot get " + getPersistentClass() + " id=" + id, e);
			transaction.rollback();
			throw new DaoException("Cannot get " + getPersistentClass() + " id=" + id, e);
		} finally{
			closeSession(session);
		}
		LOGGER.debug("Get method is complete, id=" + id);
		return entity;
	}
	
	@Override
	public List<E> readAll() throws DaoException {
		LOGGER.debug("Getting list of objects");
		List<E> entities = new ArrayList<E>();
		Session session = null;
		Transaction transaction = null;
		try{
			session = getSessionFactory().openSession();
			LOGGER.debug("Session is open");
			transaction = session.beginTransaction();
			LOGGER.debug("Transaction is begin");
			List<P> pojos = session.createCriteria(getPersistentClass()).list();
			LOGGER.debug("Objects are received");
			transaction.commit();
			LOGGER.debug("Transaction is commit");
			for(P pojo : pojos){
				entities.add(transformPojoToEntity(pojo));
			}
			LOGGER.debug("Pojos are transform in entities");
		} catch(HibernateException e){
			LOGGER.error("Cannot get all " + getPersistentClass(), e);
			transaction.rollback();
			throw new DaoException("Cannot get all; " + getPersistentClass(), e);
		} finally{
			closeSession(session);
		}
		LOGGER.debug("ReadAll method is complete");
		return entities;
	}

	@Override
	public boolean update(E entity) throws DaoException {
		LOGGER.debug("Updating object= " + entity);
		P pojo = transformEntityToPojo(entity);
		Session session = null;
		Transaction transaction = null;
		boolean isUpdated = false;
		try{
			session = getSessionFactory().openSession();
			LOGGER.debug("Session is open");
			transaction = session.beginTransaction();
			LOGGER.debug("Transaction is begin");
			session.update(pojo);
			LOGGER.debug("Object is update");
			transaction.commit();
			LOGGER.debug("Transaction is commit");
			isUpdated = true;
		} catch(HibernateException e){
			LOGGER.error("Cannot update object = " + entity, e);
			transaction.rollback();
			throw new DaoException("Cannot update object = " + entity, e);
		} finally {
			closeSession(session);
		}
		LOGGER.debug("Update method is complete, " + entity);
		return isUpdated;
	}

	@Override
	public boolean delete(Integer id) throws DaoException {
		LOGGER.debug("Deleting object by key=" + id);
		Session session = null;
		Transaction transaction = null;
		boolean isDeleted = false;
		try{
			session = getSessionFactory().openSession();
			LOGGER.debug("Session is open");
			transaction = session.beginTransaction();
			LOGGER.debug("Transaction is begin");
			P pojo = (P) session.get(getPersistentClass(), id);
			LOGGER.debug("Object is get");
			session.delete(pojo);
			LOGGER.debug("Object is delete");
			transaction.commit();
			LOGGER.debug("Transaction is commit");
			isDeleted = true;
		} catch(HibernateException e){
			LOGGER.error("Cannot delete " + getPersistentClass() + " id=" + id, e);
			transaction.rollback();
			throw new DaoException("Cannot delete " + getPersistentClass() + " id=" + id, e);
		} finally {
			closeSession(session);
		}
		LOGGER.debug("Delete method is complete, id=" + id);
		return isDeleted;
	}
	
	private void closeSession(Session session){
		if (session != null && session.isOpen()) {
	        session.close();
	        LOGGER.debug("Session is close");
	      }
	}
	
	protected abstract Class<P> getPersistentClass();
	
	protected abstract P transformEntityToPojo(E entity);
	
	protected abstract E transformPojoToEntity(P pojo);
}
