package by.agency.travel.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import by.agency.travel.entity.Role;
import by.agency.travel.entity.Tour;
import by.agency.travel.entity.User;
import by.agency.travel.hibernate.dao.exception.DaoException;
import by.agency.travel.hibernate.dao.impl.RoleDaoImpl;
import by.agency.travel.hibernate.dao.impl.TourDaoImpl;
import by.agency.travel.hibernate.dao.impl.UserDaoImpl;
import by.agency.travel.hibernate.dao.util.HibernateUtil;

public class Test {
	public static void main(String[] args) throws DaoException {
		//UserDaoImpl userDao = new UserDaoImpl();
		//userDao.setSessionFactory(HibernateUtil.getSessionFactory());
		GenericDao<Role> roleDao = RoleDaoImpl.getInstance();
		roleDao.setSessionFactory(HibernateUtil.getSessionFactory());
		//TourDaoImpl tourDao = new TourDaoImpl();
		//tourDao.setSessionFactory(HibernateUtil.getSessionFactory());
		
		Role role = new Role();
		role.setName("Role");
		roleDao.create(role);
		System.out.println(roleDao.read(3));
		role.setId(3);
		role.setName("newRole");
		roleDao.update(role);
	    System.out.println("========Все роли=========");
	    for(Role roles : roleDao.readAll()){
	    	System.out.println(roles);
	    }
	
	}
}