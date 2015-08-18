package by.agency.travel.service;

import by.agency.travel.entity.User;
import by.agency.travel.service.exception.ServiceException;

public interface UserService {
	
	User findUser(String login, String pass) throws ServiceException;
}
