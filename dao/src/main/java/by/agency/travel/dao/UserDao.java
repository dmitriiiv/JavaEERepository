package by.agency.travel.dao;

import java.util.List;

import by.agency.travel.dao.exception.DaoException;
import by.agency.travel.entity.Role;

public interface UserDao {
	
	void addRole(int userId, int roleId) throws DaoException;

	List<Role> findRoles(int userId) throws DaoException;
}
