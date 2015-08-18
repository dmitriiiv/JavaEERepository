package by.agency.travel.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.agency.travel.dao.GenericDao;
import by.agency.travel.entity.Role;
import by.agency.travel.service.RoleService;

public class RoleServiceImpl implements RoleService{
	private static final Logger LOGGER = Logger.getLogger(RoleServiceImpl.class);
	private GenericDao<Role> dao;
	
	public RoleServiceImpl(GenericDao<Role> dao){
		LOGGER.debug("Run RoleServiceImpl method");
		this.dao = dao;
	}

	public List<Role> findRoles() {
		LOGGER.debug("Run findRoles method");
		return dao.readAll();
	}
	
}
