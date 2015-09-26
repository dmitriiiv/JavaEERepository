package by.agency.travel.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import by.agency.travel.hibernate.dao.exception.DaoException;

public interface GenericDao<E> {
	Integer create(E entity) throws DaoException;
	
	E read(Integer id) throws DaoException;
	
	List<E> readAll() throws DaoException;
	
	boolean update(E entity) throws DaoException;
	
	boolean delete(Integer id) throws DaoException;

	void setSessionFactory(SessionFactory sessionFactory);
}
