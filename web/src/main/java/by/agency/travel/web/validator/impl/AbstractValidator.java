package by.agency.travel.web.validator.impl;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;

import org.springframework.validation.Errors;

public abstract class AbstractValidator<T> implements org.springframework.validation.Validator{
	
	@Inject 
	private javax.validation.Validator validator;
	
	public boolean supports(Class<?> aClass) {
		return Class.class.isAssignableFrom(aClass);
	}
	
	public void validate(Object o, Errors errors) {
		T t = (T) o;
		String attributeParam = getAttributeParam();
		Class<?> validationMarker = getValidationMarker();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, validationMarker);
		for(ConstraintViolation<T> constraintViolation : constraintViolations){
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, attributeParam, message);
		}
	}
	
	public abstract String getAttributeParam();
	
	public abstract Class<?> getValidationMarker();
}
