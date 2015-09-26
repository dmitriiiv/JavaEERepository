package by.agency.travel.service;

import java.util.List;

import by.agency.travel.entity.Tour;
import by.agency.travel.service.exception.ServiceException;

public interface TourService {
	
	List<Tour> findTours() throws ServiceException;
	
	Tour findTourById(int id) throws ServiceException;

	Integer addTour(String heading, String text, int duration, int price) throws ServiceException;

}
