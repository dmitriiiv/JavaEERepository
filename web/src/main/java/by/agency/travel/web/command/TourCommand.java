package by.agency.travel.web.command;

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

import static by.agency.travel.web.util.PropertiesManager.PAGE;

public class TourCommand implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(TourCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("Run execute method");
		GenericDao<Tour> dao = TourDaoImpl.getInstance();
		dao.setSessionFactory(HibernateUtil.getSessionFactory());
		TourService service = new TourServiceImpl(dao);
		synchronized (service) {
	        int tourId = Integer.parseInt(request.getParameter("id"));
	        try {
				request.setAttribute("tour", service.findTourById(tourId));
			} catch (ServiceException e) {
				LOGGER.error("Error execute method", e);
			}
		}
        return PAGE.getProperty("path.page.tour");
	}

}
