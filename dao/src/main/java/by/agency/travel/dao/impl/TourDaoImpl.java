package by.agency.travel.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.agency.travel.dao.AbstractDao;
import by.agency.travel.entity.Tour;

import static by.agency.travel.dao.util.Constants.*;
import static by.agency.travel.dao.util.PropertiesManager.*;

public class TourDaoImpl extends AbstractDao<Tour>{
	private static final Logger LOGGER = Logger.getLogger(TourDaoImpl.class);
	private static TourDaoImpl instance;
	
	private TourDaoImpl() {
	}
	
	public synchronized static TourDaoImpl getInstance(){
		LOGGER.debug("Run getInstance method");
		if(instance == null){
			instance = new TourDaoImpl();
		}
		return instance;
	}

	@Override
	protected void setParameters(String methodName, Statement statement, Tour object) throws SQLException {
		LOGGER.debug("Run setParameters method");
		if(methodName.equals(METHOD_NAME_CREATE)){
			((PreparedStatement) statement).setString(1, object.getHeading());
			((PreparedStatement) statement).setString(2, object.getText());
			((PreparedStatement) statement).setInt(3, object.getDuration());
			((PreparedStatement) statement).setInt(4, object.getPrice());
		} else if(methodName.equals(METHOD_NAME_READ)){
			((PreparedStatement)statement).setInt(1, object.getId());
		}
	}

	@Override
	protected String getSql(String methodName) {
		LOGGER.debug("Run getSql method");
		if(methodName.equals(METHOD_NAME_CREATE)){
			return SQL_REQUEST.getProperty("sql.create.tour");
		} else if(methodName.equals(METHOD_NAME_READ)){
			return SQL_REQUEST.getProperty("sql.read.tour");
		} else if(methodName.equals(METHOD_NAME_READ_ALL)){
			return SQL_REQUEST.getProperty("sql.read.all.tours");
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	protected Tour create(ResultSet resultSet) throws SQLException {
		LOGGER.debug("Run create method");
		Tour tour = new Tour();
		resultSet.next();
		tour.setId(resultSet.getInt(PARAM_TOUR_ID));
		tour.setHeading(resultSet.getString(PARAM_TOUR_HEADING));
		tour.setText(resultSet.getString(PARAM_TOUR_TEXT));
		tour.setDuration(resultSet.getInt(PARAM_TOUR_DURATION));
		tour.setPrice(resultSet.getInt(PARAM_TOUR_PRICE));
		return tour;
	}

	@Override
	protected List<Tour> createList(ResultSet resultSet) throws SQLException {
		LOGGER.debug("Run createList method");
		List<Tour> tours = new ArrayList<Tour>();
		while(resultSet.next()){
			Tour tour = new Tour();
			tour.setId(resultSet.getInt(PARAM_TOUR_ID));
			tour.setHeading(resultSet.getString(PARAM_TOUR_HEADING));
			tour.setText(resultSet.getString(PARAM_TOUR_TEXT));
			tour.setDuration(resultSet.getInt(PARAM_TOUR_DURATION));
			tour.setPrice(resultSet.getInt(PARAM_TOUR_PRICE));
			tours.add(tour);
		}
		return tours;
	}

}
