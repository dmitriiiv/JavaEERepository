package by.agency.travel.service;

import by.agency.travel.entity.User;

public interface UserService {
	
	User findUserByLogin(String login);
	
	Integer registerUser(User entity);
}
