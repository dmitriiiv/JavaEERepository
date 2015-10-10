package by.agency.travel.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.agency.travel.entity.Role;
import by.agency.travel.entity.Tour;
import by.agency.travel.service.config.ServiceConfig;
import by.agency.travel.service.impl.RoleServiceImpl;
import by.agency.travel.service.impl.TourServiceImpl;
import by.agency.travel.service.impl.UserServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
    	RoleService roleService = context.getBean(RoleServiceImpl.class);
    	UserService userService = context.getBean(UserServiceImpl.class);
    	TourService tourService = context.getBean(TourServiceImpl.class);
    	Iterable<Role> roles = roleService.findRoles();
    	Iterable<Tour> tours = tourService.findTours();
    	for(Role role : roles){
    		System.out.println(role);
    	}
    	System.out.println("#########");
    	for(Tour tour : tours){
    		System.out.println(tour);
    	}
    	System.out.println("#########");
    	System.out.println(userService.findUserByLogin("login@gmail.com"));
    	context.close();
    }
}
