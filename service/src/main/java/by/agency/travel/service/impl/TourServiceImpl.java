package by.agency.travel.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.agency.travel.dao.GenericDao;
import by.agency.travel.entity.Tour;
import by.agency.travel.service.TourService;

public class TourServiceImpl implements TourService{
	private static final Logger LOGGER = Logger.getLogger(TourServiceImpl.class);
	private GenericDao<Tour> dao;
	
	
	public TourServiceImpl(GenericDao<Tour> dao) {
		LOGGER.debug("Run TourServiceImpl method");
		this.dao = dao;
	}

	public List<Tour> findTours() {
		LOGGER.debug("Run findTour method");
		return dao.readAll();
	}

	public Tour findTourById(int id) {
		LOGGER.debug("Run findTourById method");
		Tour tour = new Tour();
		tour.setId(id);
		return dao.read(tour);
	}

	public boolean addTour(String heading, String text, int duration, int price) {
		LOGGER.debug("Run addTour method");
		Tour tour = new Tour();
		tour.setHeading(heading);
		tour.setText(text);
		tour.setDuration(duration);
		tour.setPrice(price);
		return dao.create(tour);
	}
	
}
