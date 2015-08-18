package by.agency.travel.service;

import java.util.List;

import by.agency.travel.entity.Tour;

public interface TourService {
	
	List<Tour> findTours();
	
	Tour findTourById(int id);
	
	boolean addTour(String heading, String text, int duration, int price);

}
