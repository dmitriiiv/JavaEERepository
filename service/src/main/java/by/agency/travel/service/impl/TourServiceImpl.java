package by.agency.travel.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import by.agency.travel.dao.pojo.TourPojo;
import by.agency.travel.dao.repository.TourRepository;
import by.agency.travel.entity.Tour;
import by.agency.travel.service.TourService;

@Service
public class TourServiceImpl implements TourService{
	
	private static final Logger LOGGER = Logger.getLogger(TourServiceImpl.class);
	
	@Inject
	private TourRepository tourRepository;
	
	@Override
	public List<Tour> findTours() {
		LOGGER.info("Run findTours method");
		List<Tour> tours = new ArrayList<>();
		for(TourPojo pojo : tourRepository.findAll(new Sort(Sort.Direction.DESC, "id"))){
			tours.add(transformPojoToVO(pojo));
		}
		return tours;
	}

	@Override
	public Tour findTourById(int id) {
		LOGGER.info("Run findTourById method, id=" + id);
		return transformPojoToVO(tourRepository.findOne(id));
	}

	@Override
	public Integer addTour(Tour entity) {
		LOGGER.info("Run addTour method");
		TourPojo pojo = transformVOToPojo(entity);
		return tourRepository.saveAndFlush(pojo).getId();
	}
	
	@Override
	public void delete(int id){
		LOGGER.info("Run delete method");
		tourRepository.delete(id);
	}
	
	private Tour transformPojoToVO(TourPojo pojo){
		LOGGER.info("Run transformPojoToVO method");
		if(pojo == null){
			return null;
		} else {
			return new Tour(pojo.getId(), pojo.getHeading(), pojo.getText(), pojo.getDuration(), pojo.getPrice());
		}
	}
	
	private TourPojo transformVOToPojo(Tour entity){
		LOGGER.info("Run transformVOToPojo method");
		if(entity == null){
			return null;
		} else {
			return new TourPojo(entity.getId(), entity.getHeading(), entity.getParagraphs(), entity.getDuration(), entity.getPrice());
		}
	}
	
	/*private List<String> transformTextToParagraphs(String text) {
		LOGGER.info("Run transformTextToParagraphs method");
        String[] paragraphs = text.split("\n");
        return new ArrayList<String>(Arrays.asList(paragraphs));
    }*/
}
