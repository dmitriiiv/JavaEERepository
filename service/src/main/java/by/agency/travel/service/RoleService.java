package by.agency.travel.service;

import java.util.List;

import by.agency.travel.entity.Role;

public interface RoleService {
	
	List<Role> findRoles();
	
	Role findRoleByName(String name);
}
