package by.agency.travel.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import by.agency.travel.entity.Tour;
import by.agency.travel.hibernate.dao.GenericDao;
import by.agency.travel.hibernate.dao.exception.DaoException;
import by.agency.travel.service.TourService;
import by.agency.travel.service.exception.ServiceException;

public class TourServiceImpl implements TourService{
	private static final Logger LOGGER = Logger.getLogger(TourServiceImpl.class);
	private GenericDao<Tour> dao;
	
	
	public TourServiceImpl(GenericDao<Tour> dao) {
		LOGGER.info("Run TourServiceImpl method");
		this.dao = dao;
	}

	@Override
	public List<Tour> findTours() throws ServiceException {
		LOGGER.info("Run findTour method");
		try {
			return dao.readAll();
		} catch (DaoException e) {
			LOGGER.error("Cannot find all tour", e);
			throw new ServiceException("Cannot find all tour", e);
		}
	}

	@Override
	public Tour findTourById(int id) throws ServiceException {
		LOGGER.info("Run findTourById method, id=" + id);
		try {
			return dao.read(id);
		} catch (DaoException e) {
			LOGGER.error("Cannot find tour by id = " + id, e);
			throw new ServiceException("Cannot find tour by id = " + id, e);
		}
	}

	@Override
	public Integer addTour(String heading, String text, int duration, int price) throws ServiceException {
		LOGGER.info("Run addTour method");
		Tour tour = new Tour();
		tour.setHeading(heading);
		tour.setParagraphs(transformTextToParagraphs(text));
		tour.setDuration(duration);
		tour.setPrice(price);
		try {
			return dao.create(tour);
		} catch (DaoException e) {
			LOGGER.error("Cannot add tour = " + tour , e);
			throw new ServiceException("Cannot add tour = " + tour , e);
		}
	}
	
	private List<String> transformTextToParagraphs(String text) {
        String[] paragraphs = text.split("\n");
        return new ArrayList<String>(Arrays.asList(paragraphs));
    }
}
