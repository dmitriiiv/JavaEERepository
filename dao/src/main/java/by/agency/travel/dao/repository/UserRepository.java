package by.agency.travel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.agency.travel.dao.pojo.UserPojo;

public interface UserRepository extends JpaRepository<UserPojo, Integer>{
	
	UserPojo findUserByLogin(String login);
}
