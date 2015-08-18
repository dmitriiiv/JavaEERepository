package by.agency.travel.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import by.agency.travel.dao.GenericDao;
import by.agency.travel.dao.UserDao;
import by.agency.travel.entity.Role;
import by.agency.travel.entity.User;
import by.agency.travel.service.UserService;

public class UserServiceImpl implements UserService{
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	private GenericDao<User> dao;
	
	public UserServiceImpl(GenericDao<User> dao){
		LOGGER.info("Run UserServiceImpl method");
		this.dao = dao;
	}

	public User findUser(String login, String pass) {
		LOGGER.info("Run findUser method, login=" + login);
		User enteredUser = new User();
		enteredUser.setLogin(login);
		String md5Pass = md5Apache(pass);
		enteredUser.setPass(md5Pass);
		User userInDB = dao.read(enteredUser);
		if(userInDB != null){
			List<Role> roles = ((UserDao)dao).findRoles(userInDB.getId());
			userInDB.setRoles(roles);
			return userInDB;
		} else {
			return null;
		}
	}

	private String md5Apache(String pass){
		LOGGER.info("Run md5Apache method");
		return DigestUtils.md5Hex(pass);
	}
}
