package by.agency.travel.service;

import static by.agency.travel.service.util.PropertiesManager.MESSAGE;

import java.util.Scanner;

import by.agency.travel.dao.impl.TourDaoImpl;
import by.agency.travel.dao.impl.UserDaoImpl;
import by.agency.travel.entity.Tour;
import by.agency.travel.service.exception.ServiceException;
import by.agency.travel.service.impl.TourServiceImpl;
import by.agency.travel.service.impl.UserServiceImpl;

public class App 
{
    public static void main( String[] args ) throws ServiceException
    {
    	Scanner in = new Scanner(System.in);
    	int choice;
    	do{
    		printMenu();
    		choice = in.nextInt();
    		switch(choice){
    		case 1: login(in);
    				break;
    		case 2: findTours();
    				break;
    		case 3: findTourById(in);
    				break;
    		case 4: addTour(in);
    				break;
    		default: continue;
    		}
    		System.out.println(MESSAGE.getProperty("check"));
    		while(true){
    			if(in.next() != null){
    				break;
    			}
    		}
    	} while(choice != 0);
		in.close();
    }
    
    private static void printMenu(){
    	System.out.println(MESSAGE.getProperty("item.find.user"));
    	System.out.println(MESSAGE.getProperty("item.find.all.tours"));
    	System.out.println(MESSAGE.getProperty("item.find.tour"));
    	System.out.println(MESSAGE.getProperty("item.add.tour"));
    	System.out.println(MESSAGE.getProperty("exit"));
    	System.out.println(MESSAGE.getProperty("title"));
    }
    
    private static void login(Scanner scanner) throws ServiceException{
    	UserService service = new UserServiceImpl(UserDaoImpl.getInstance());
    	System.out.println(MESSAGE.getProperty("input.user.login"));
    	String login = scanner.next();
    	System.out.println(MESSAGE.getProperty("input.user.pass"));
    	String pass = scanner.next();
    	System.out.println(service.findUser(login, pass));
    }
    
    private static void findTours() throws ServiceException{
    	TourService service = new TourServiceImpl(TourDaoImpl.getInstance());
    	for(Tour tour : service.findTours()){
    		System.out.println(tour);
    	}
    }
    
    private static void findTourById(Scanner scanner) throws ServiceException{
    	TourService service = new TourServiceImpl(TourDaoImpl.getInstance());
    	System.out.println(MESSAGE.getProperty("input.tour.id"));
    	int tourId = scanner.nextInt();
    	System.out.println(service.findTourById(tourId));
    }
    
    private static void addTour(Scanner scanner) throws ServiceException{
    	TourService service = new TourServiceImpl(TourDaoImpl.getInstance());
    	System.out.println(MESSAGE.getProperty("input.tour.heading"));
    	String heading = scanner.next();
    	System.out.println(MESSAGE.getProperty("input.tour.text"));
    	String text = scanner.next();
    	System.out.println(MESSAGE.getProperty("input.tour.duration"));
    	int duration = scanner.nextInt();
    	System.out.println(MESSAGE.getProperty("input.tour.price"));
    	int price = scanner.nextInt();
    	System.out.println(service.addTour(heading, text, duration, price));
    }
}
