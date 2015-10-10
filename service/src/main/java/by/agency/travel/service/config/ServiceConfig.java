package by.agency.travel.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;

import by.agency.travel.dao.config.DataConfig;
import by.agency.travel.service.RoleService;
import by.agency.travel.service.TourService;
import by.agency.travel.service.UserService;
import by.agency.travel.service.impl.RoleServiceImpl;
import by.agency.travel.service.impl.TourServiceImpl;
import by.agency.travel.service.impl.UserDetailsServiceImpl;
import by.agency.travel.service.impl.UserServiceImpl;

@Configuration
@ComponentScan(basePackages = "by.agency.travel.service")
@Import(DataConfig.class)
public class ServiceConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public UserService userService(){
		return new UserServiceImpl();
	}
	
	@Bean
	public TourService tourService(){
		return new TourServiceImpl();
	}
	
	@Bean
	public RoleService roleService(){
		return new RoleServiceImpl();
	}
}
