package by.agency.travel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.agency.travel.dao.pojo.TourPojo;

public interface TourRepository extends JpaRepository<TourPojo, Integer>{

}
