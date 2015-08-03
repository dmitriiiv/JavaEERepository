package by.agency.travel.dao;

import java.util.List;

import by.agency.travel.entity.Role;

public interface UserDao {
	
	void addRole(int userId, int roleId);

	List<Role> findRoles(int userId);
}
