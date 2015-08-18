package by.agency.travel.dao;

import java.util.List;

import by.agency.travel.dao.exception.DaoException;

public interface GenericDao<T> {
	
	boolean create(T object) throws DaoException;
	
	T read(T object) throws DaoException;
	
	List<T> readAll() throws DaoException;
}
