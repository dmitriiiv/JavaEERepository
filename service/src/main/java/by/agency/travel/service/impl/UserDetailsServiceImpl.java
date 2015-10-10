package by.agency.travel.service.impl;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import by.agency.travel.service.UserService;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Inject
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return userService.findUserByLogin(login);
	}

}
