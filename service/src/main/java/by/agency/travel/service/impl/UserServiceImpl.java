package by.agency.travel.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import by.agency.travel.entity.User;
import by.agency.travel.hibernate.dao.UserDao;
import by.agency.travel.hibernate.dao.exception.DaoException;
import by.agency.travel.service.UserService;
import by.agency.travel.service.exception.ServiceException;

public class UserServiceImpl implements UserService{
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	private UserDao dao;
	
	public UserServiceImpl(UserDao dao){
		LOGGER.info("Run UserServiceImpl method");
		this.dao = dao;
	}

	public User findUser(String login, String pass) throws ServiceException {
		LOGGER.info("Run findUser method, login=" + login);
		User userInDB = null;
		String md5Pass = md5Apache(pass);
		try {
			userInDB = dao.getByLoginAndPass(login, md5Pass);
		} catch (DaoException e) {
			LOGGER.error("Cannot find user, login = " + login , e);
			throw new ServiceException("Cannot find user, login = " + login , e);
		}
		return userInDB;
	}

	private String md5Apache(String pass){
		LOGGER.info("Run md5Apache method");
		return DigestUtils.md5Hex(pass);
	}
}
