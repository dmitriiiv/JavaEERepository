package by.agency.travel.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	
	private static final Logger LOGGER = Logger.getLogger(ErrorController.class);

	@RequestMapping(value = "/error")
	public String handle(HttpServletRequest request, ModelAndView model) {
		Object statusCode = request.getAttribute("javax.servlet.error.status_code");
		LOGGER.error("Server return error: " + statusCode.toString());
		request.setAttribute("status", statusCode);
		request.setAttribute("reason", request.getAttribute("javax.servlet.error.message"));
		request.setAttribute("errorUri", request.getAttribute("javax.servlet.error.request_uri"));
		return "/errors/error";
	}
}
