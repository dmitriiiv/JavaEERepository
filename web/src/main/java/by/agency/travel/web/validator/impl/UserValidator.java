package by.agency.travel.web.validator.impl;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.Errors;

import by.agency.travel.entity.User;
import by.agency.travel.web.validator.UserChecks;

public class UserValidator extends AbstractValidator<User>{

	@Inject
	UserDetailsService userDetailsService;
	
	@Override
	public String getAttributeParam() {
		return "userParam";
	}

	@Override
	public Class<?> getValidationMarker() {
		return UserChecks.class;
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;
		String login = user.getLogin();
		UserDetails userDetails = userDetailsService.loadUserByUsername(login);
		if(userDetails != null){
			errors.rejectValue("login", "registration.error");
		}
		super.validate(o, errors);
	}
}
