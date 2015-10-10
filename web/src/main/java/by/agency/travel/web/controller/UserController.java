package by.agency.travel.web.controller;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import by.agency.travel.entity.User;
import by.agency.travel.service.UserService;
import by.agency.travel.web.validator.impl.AbstractValidator;

@Controller
public class UserController {

	@Inject
	private AbstractValidator userValidator;
	
	@Inject
	private UserService userService;
	
	@Inject
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String viewRegistration(Model model) {
		model.addAttribute("userParam", new User());
		return "registration";
	}
	
	@RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
	public ModelAndView registrationUser(@ModelAttribute("userParam") User user, 
										 BindingResult result, SessionStatus status, Errors errors) {
		userValidator.validate(user, errors);
		if(result.hasErrors()) {
			return new ModelAndView("registration", "userParam", user);
		} else {
			String encodePassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodePassword);
			userService.registerUser(user);
			status.setComplete();
		}
		return new ModelAndView("redirect:/login", "userParam", user);
	}
}
