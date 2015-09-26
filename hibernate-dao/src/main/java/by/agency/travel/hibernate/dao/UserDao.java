package by.agency.travel.hibernate.dao;

import by.agency.travel.entity.User;
import by.agency.travel.hibernate.dao.exception.DaoException;

public interface UserDao extends GenericDao<User>{
	User getByLoginAndPass(String login, String pass) throws DaoException;
}
