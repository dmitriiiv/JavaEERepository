package by.agency.travel.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import by.agency.travel.dao.pojo.RolePojo;
import by.agency.travel.dao.pojo.UserPojo;
import by.agency.travel.dao.repository.UserRepository;
import by.agency.travel.entity.Role;
import by.agency.travel.entity.User;
import by.agency.travel.service.RoleService;
import by.agency.travel.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	@Inject
	private UserRepository userRepository;
	
	@Inject
	private RoleService roleService;

	@Override
	public User findUserByLogin(String login) {
		LOGGER.info("Run findUser method, login=" + login);
		UserPojo userPojo = userRepository.findUserByLogin(login);
		return transformPojoToVO(userPojo);
	}
	
	@Override
	public Integer registerUser(User entity){
		LOGGER.info("Run registerUser method");
		List<Role> roles = new ArrayList<>();
		roles.add(roleService.findRoleByName("user"));
		LOGGER.info("List default user role");
		entity.setRoles(roles);
		UserPojo pojo = userRepository.saveAndFlush(transformVOToPojo(entity));
		return pojo.getId();
	}
	
	private User transformPojoToVO(UserPojo pojo){
		if(pojo == null){
			return null;
		} else {
			List<Role> roles = new ArrayList<>();
			for(RolePojo rolePojo : pojo.getRoles()){
				roles.add(new Role(rolePojo.getId(), rolePojo.getName()));
			}
			return new User(pojo.getId(), pojo.getLogin(), pojo.getPass(), roles);
		}
	}
	
	private UserPojo transformVOToPojo(User entity){
		if(entity == null){
			return null;
		} else {
			List<RolePojo> roles = new ArrayList<>();
			for(Role role : entity.getRoles()){
				roles.add(new RolePojo(role.getId(), role.getName()));
			}
			return new UserPojo(entity.getId(), entity.getLogin(), entity.getPassword(), roles);
		}
	}
}
