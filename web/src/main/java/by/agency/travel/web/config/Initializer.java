package by.agency.travel.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

import by.agency.travel.service.config.ServiceConfig;

public class Initializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);
		context.register(SecurityConfig.class);
		context.register(ServiceConfig.class);
		context.register(Beans.class);
		
		servletContext.setInitParameter("log4jConfigLocation", "classpath:log4j.properties");

        servletContext.addListener(new Log4jConfigListener());
        servletContext.addListener(new ContextLoaderListener(context));

        context.setServletContext(servletContext);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(false);
        Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
	}
}
