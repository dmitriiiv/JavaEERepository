package by.agency.travel.web.command.factory;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.agency.travel.web.command.ActionCommand;
import by.agency.travel.web.command.EmptyCommand;
import by.agency.travel.web.command.client.CommandEnum;

public class ActionFactory {
	private static final Logger LOGGER = Logger.getLogger(ActionFactory.class);

	public static ActionCommand defineCommand(HttpServletRequest request) {
		LOGGER.debug("Run ActionCommand method");
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
        	LOGGER.error("ActionFactory exception in defineCommand method", e);
        }
        return current;
    }
}
