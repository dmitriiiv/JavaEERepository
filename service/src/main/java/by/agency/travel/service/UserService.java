package by.agency.travel.service;

import by.agency.travel.entity.User;

public interface UserService {
	
	User findUser(String login, String pass);
}
