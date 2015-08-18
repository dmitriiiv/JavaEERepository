package by.agency.travel.web.command;

import static by.agency.travel.web.util.PropertiesManager.PAGE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class EmptyCommand implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(EmptyCommand.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("Run execute method");
		return PAGE.getProperty("path.page.login");
	}
}
