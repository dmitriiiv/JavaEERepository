package by.agency.travel.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.agency.travel.dao.impl.TourDaoImpl;
import by.agency.travel.dao.impl.UserDaoImpl;
import by.agency.travel.entity.User;
import by.agency.travel.service.TourService;
import by.agency.travel.service.UserService;
import by.agency.travel.service.exception.ServiceException;
import by.agency.travel.service.impl.TourServiceImpl;
import by.agency.travel.service.impl.UserServiceImpl;

import static by.agency.travel.web.util.PropertiesManager.*;

public class LoginCommand implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("Run execute method");
		String page;
        User user = getUser(request);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            TourService service = new TourServiceImpl(TourDaoImpl.getInstance());
            synchronized (service) {
                try {
					request.setAttribute("tourList", service.findTours());
				} catch (ServiceException e) {
					LOGGER.error("Error execute method", e);
				}
			}
            page = PAGE.getProperty("path.page.tour.list");
        } else {
            request.setAttribute("errorLoginPassMessage", ERROR_MESSAGE.getProperty("message.login"));
            page = PAGE.getProperty("path.page.login");
        }
        return page;
    }

    private User getUser(HttpServletRequest request) {
    	LOGGER.debug("Run getUser method");
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        User user = null;
        if (login == null || pass == null) {
        	user = (User) request.getSession().getAttribute("user");
        } else if(isValid(login)){
        	UserService userService = new UserServiceImpl(UserDaoImpl.getInstance());
        	synchronized (userService) {
                try {
					user = userService.findUser(login, pass);
				} catch (ServiceException e) {
					LOGGER.error("Error getUser method", e);
				}
			}
        }
        return user;
    }
    
    private boolean isValid(String login){
    	LOGGER.debug("Run isValid method");
    	if(login.matches(".+[@].+") && login.length() < 20){
    		return true;
    	} else {
    		return false;
    	}
    }
}
