package by.agency.travel.hibernate.dao.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {
	//private static final Logger LOGGER = Logger.getLogger(HibernateUtil.class);
	private static final SessionFactory sessionFactory;
	static {
		try{
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch(Throwable ex){
			//LOGGER.error("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
