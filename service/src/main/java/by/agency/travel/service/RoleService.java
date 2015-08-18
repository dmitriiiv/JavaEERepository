package by.agency.travel.service;

import java.util.List;

import by.agency.travel.entity.Role;
import by.agency.travel.service.exception.ServiceException;

public interface RoleService {
	
	List<Role> findRoles() throws ServiceException;

}
