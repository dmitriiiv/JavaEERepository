package by.agency.travel.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.agency.travel.entity.User;

import static by.agency.travel.web.util.PropertiesManager.*;

public class AddTourCommand implements ActionCommand{
	private static final Logger LOGGER = Logger.getLogger(AddTourCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("Run execute method");
		String page;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            page = PAGE.getProperty("path.page.addition");
        } else {
            page = PAGE.getProperty("path.page.login");
        }
        return page;
	}

}
