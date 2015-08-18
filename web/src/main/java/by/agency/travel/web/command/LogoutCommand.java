package by.agency.travel.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import static by.agency.travel.web.util.PropertiesManager.PAGE;

public class LogoutCommand implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(LogoutCommand.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("Run execute method");
		request.getSession().removeAttribute("user");
	    return PAGE.getProperty("path.page.login");
	}
}
