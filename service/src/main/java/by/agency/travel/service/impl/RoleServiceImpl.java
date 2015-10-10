package by.agency.travel.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import by.agency.travel.dao.pojo.RolePojo;
import by.agency.travel.dao.repository.RoleRepository;
import by.agency.travel.entity.Role;

import by.agency.travel.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	private static final Logger LOGGER = Logger.getLogger(RoleServiceImpl.class);
	
	@Inject
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> findRoles() {
		LOGGER.info("Run findRoles method");
		List<Role> roles = new ArrayList<>();
		for(RolePojo pojo : roleRepository.findAll()){
			roles.add(transformPojoToVO(pojo));
		}
		return roles;
	}
	
	@Override
	public Role findRoleByName(String name){
		LOGGER.info("Run findRoleByName method");
		RolePojo pojo = roleRepository.findRoleByName(name);
		return transformPojoToVO(pojo);
	}
	
	private Role transformPojoToVO(RolePojo pojo){
		LOGGER.info("Run findRoles method");
		if(pojo == null){
			return null;
		} else {
			return new Role(pojo.getId(), pojo.getName());
		}
	}
}
