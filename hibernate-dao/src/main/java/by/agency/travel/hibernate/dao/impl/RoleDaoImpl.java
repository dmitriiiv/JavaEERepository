package by.agency.travel.hibernate.dao.impl;

import org.apache.log4j.Logger;

import by.agency.travel.entity.Role;
import by.agency.travel.hibernate.dao.AbstractDao;
import by.agency.travel.hibernate.dao.pojos.RolePojo;

public class RoleDaoImpl extends AbstractDao<Role, RolePojo>{
	private static RoleDaoImpl instance;
	private static final Logger LOGGER = Logger.getLogger(RoleDaoImpl.class);
	
	private RoleDaoImpl(){
	}
	
	public synchronized static RoleDaoImpl getInstance(){
		LOGGER.debug("Run getInstance method");
		if(instance == null){
			instance = new RoleDaoImpl();
		}
		return instance;
	}

	@Override
	protected Class<RolePojo> getPersistentClass() {
		return RolePojo.class;
	}

	@Override
	protected RolePojo transformEntityToPojo(Role role) {
		RolePojo pojo = new RolePojo(role.getId(), role.getName());
		return pojo;
	}

	@Override
	protected Role transformPojoToEntity(RolePojo pojo) {
		Role role = new Role(pojo.getId(), pojo.getName());
		return role;
	}
}
