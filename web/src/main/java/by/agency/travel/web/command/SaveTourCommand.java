package by.agency.travel.web.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.agency.travel.entity.Tour;
import by.agency.travel.hibernate.dao.GenericDao;
import by.agency.travel.hibernate.dao.impl.TourDaoImpl;
import by.agency.travel.hibernate.dao.util.HibernateUtil;
import by.agency.travel.service.TourService;
import by.agency.travel.service.exception.ServiceException;
import by.agency.travel.service.impl.TourServiceImpl;

import static by.agency.travel.web.util.PropertiesManager.*;

public class SaveTourCommand implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(SaveTourCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("Run execute method");
		String page;
        if (isAdditionTour(request) != 0) {
            try {
                response.sendRedirect("controller?command=login");
            } catch (IOException e) {
            	LOGGER.error("Error redirect", e);
            }
            page = PAGE.getProperty("path.page.tour.list");
        } else {
            request.setAttribute("errorAdditionNews", ERROR_MESSAGE.getProperty("message.addition"));
            page = PAGE.getProperty("path.page.addition");
        }
        return page;
	}

	private Integer isAdditionTour(HttpServletRequest request) {
		 LOGGER.debug("Run isAdditionNews method");
		 String heading = request.getParameter("heading");
	     String text = request.getParameter("text");
	     int duration = Integer.parseInt(request.getParameter("duration"));
	     int price = Integer.parseInt(request.getParameter("price"));
	     if(isValid(heading, text, duration, price)){
	    	 GenericDao<Tour> dao = TourDaoImpl.getInstance();
	    	 dao.setSessionFactory(HibernateUtil.getSessionFactory());
	    	 TourService service = new TourServiceImpl(dao);
	    	 synchronized (service) {
			     try {
					return service.addTour(heading, text, duration, price);
				} catch (ServiceException e) {
					LOGGER.error("Error addition tour", e);
				}
			}
	     } 
	     return 0;
	}
	
	private boolean isValid(String heading, String text, int duration, int price){
		LOGGER.debug("Run isValid method");
		if(heading.length() <= 100 || text.length() <= 65535 || duration <= 999 || price <= 999999999){
			return true;
		} else {
			return false;
		}
	}
}
