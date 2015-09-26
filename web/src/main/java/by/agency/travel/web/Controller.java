package by.agency.travel.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.agency.travel.web.command.ActionCommand;
import by.agency.travel.web.command.factory.ActionFactory;

public class Controller extends HttpServlet{
	private static final Logger LOGGER = Logger.getLogger(Controller.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		LOGGER.debug("Run init method");
		super.init(config);
		String log4j = config.getInitParameter("log4j-pass");
		String path = getServletContext().getRealPath(log4j);
		PropertyConfigurator.configure(path);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Run doGet method");
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("Run doPost method");
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("Run processRequest method");
		ActionCommand command = ActionFactory.defineCommand(request);
        try {
            String nextPage = command.execute(request, response);
            if (!response.isCommitted()) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
                requestDispatcher.forward(request, response);
            }
        } catch (ServletException | IOException e) {
            LOGGER.error("Controller exception in processRequest method", e);
        } 
	}

}
