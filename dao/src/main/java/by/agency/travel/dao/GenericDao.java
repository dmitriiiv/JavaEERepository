package by.agency.travel.dao;

import java.util.List;

public interface GenericDao<T> {
	
	void create(T object);
	
	T read(T object);
	
	List<T> readAll();
}
