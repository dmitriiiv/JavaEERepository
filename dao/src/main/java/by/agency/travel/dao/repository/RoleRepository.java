package by.agency.travel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.agency.travel.dao.pojo.RolePojo;

public interface RoleRepository extends JpaRepository<RolePojo, Integer> {

	RolePojo findRoleByName(String name);
}
