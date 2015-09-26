package by.agency.travel.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import by.agency.travel.entity.Tour;
import by.agency.travel.hibernate.dao.AbstractDao;
import by.agency.travel.hibernate.dao.pojos.TourPojo;

public class TourDaoImpl extends AbstractDao<Tour, TourPojo>{
	private static TourDaoImpl instance;
	private static final Logger LOGGER = Logger.getLogger(TourDaoImpl.class);
	
	private TourDaoImpl(){
	}

	public synchronized static TourDaoImpl getInstance(){
		LOGGER.debug("Run getInstance method");
		if(instance == null){
			instance = new TourDaoImpl();
		}
		return instance;
	}

	@Override
	protected Class<TourPojo> getPersistentClass() {
		return TourPojo.class;
	}

	@Override
	protected TourPojo transformEntityToPojo(Tour entity) {
		TourPojo pojo = new TourPojo(entity.getId(), entity.getHeading(), transformParagraphsToText(entity.getParagraphs()), entity.getDuration(), entity.getPrice());
		return pojo;
	}

	@Override
	protected Tour transformPojoToEntity(TourPojo pojo) {
		Tour tour = new Tour(pojo.getId(), pojo.getHeading(), transformTextToParagraphs(pojo.getText()), pojo.getDuration(), pojo.getPrice());
		return tour;
	}
	
	private List<String> transformTextToParagraphs(String text) {
        String[] paragraphs = text.split("\n");
        return new ArrayList<String>(Arrays.asList(paragraphs));
    }
	
	private String transformParagraphsToText(List<String> paragraphs){
		StringBuilder builder = new StringBuilder();
		for(String paragraph : paragraphs){
			builder.append(paragraph);
		}
		return new String(builder);
	}
}