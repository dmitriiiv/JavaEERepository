package by.agency.travel.web.validator.impl;

import by.agency.travel.entity.Tour;
import by.agency.travel.web.validator.TourChecks;

public class TourValidator extends AbstractValidator<Tour> {

	@Override
	public String getAttributeParam() {
		return "tourParam";
	}

	@Override
	public Class<?> getValidationMarker() {
		return TourChecks.class;
	}

}
