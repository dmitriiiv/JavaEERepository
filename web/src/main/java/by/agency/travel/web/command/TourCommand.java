package by.agency.travel.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.agency.travel.dao.GenericDao;
import by.agency.travel.dao.impl.TourDaoImpl;
import by.agency.travel.entity.Tour;
import by.agency.travel.service.TourService;
import by.agency.travel.service.impl.TourServiceImpl;

import static by.agency.travel.web.util.PropertiesManager.PAGE;

public class TourCommand implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(TourCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("Run execute method");
		GenericDao<Tour> dao = TourDaoImpl.getInstance();
		synchronized (dao) {
			TourService service = new TourServiceImpl(dao);
	        int tourId = Integer.parseInt(request.getParameter("id"));
	        request.setAttribute("tour", service.findTourById(tourId));
		}
        return PAGE.getProperty("path.page.tour");
	}

}
