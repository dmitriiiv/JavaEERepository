package by.agency.travel.dao;

import java.util.List;

public interface GenericDao<T> {
	
	boolean create(T object);
	
	T read(T object);
	
	List<T> readAll();
}
