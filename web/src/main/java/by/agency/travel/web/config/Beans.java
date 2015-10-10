package by.agency.travel.web.config;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import by.agency.travel.web.validator.impl.AbstractValidator;
import by.agency.travel.web.validator.impl.TourValidator;
import by.agency.travel.web.validator.impl.UserValidator;

@Configuration
public class Beans {

	@Bean
	public AbstractValidator userValidator() {
		return new UserValidator();
	}
	
	@Bean
	public AbstractValidator tourValidator() {
		return new TourValidator();
	}
	
	@Bean
	public javax.validation.Validator validator() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		return validatorFactory.usingContext().getValidator();
	}
	
	@Bean(name = "passwordEncoder")
	public BCryptPasswordEncoder passwordEncoder() throws Exception {
		return new BCryptPasswordEncoder();
	}
}
