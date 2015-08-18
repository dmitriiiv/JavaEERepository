package by.agency.travel.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.agency.travel.dao.GenericDao;
import by.agency.travel.dao.exception.DaoException;
import by.agency.travel.entity.Role;
import by.agency.travel.service.RoleService;
import by.agency.travel.service.exception.ServiceException;

public class RoleServiceImpl implements RoleService{
	private static final Logger LOGGER = Logger.getLogger(RoleServiceImpl.class);
	private GenericDao<Role> dao;
	
	public RoleServiceImpl(GenericDao<Role> dao){
		LOGGER.info("Run RoleServiceImpl method");
		this.dao = dao;
	}

	public List<Role> findRoles() throws ServiceException {
		LOGGER.info("Run findRoles method");
		try {
			return dao.readAll();
		} catch (DaoException e) {
			LOGGER.error("Cannot find all roles", e);
			throw new ServiceException("Cannot all find all roles", e);
		}
	}
	
}
