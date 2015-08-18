package by.agency.travel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.agency.travel.dao.AbstractDao;
import by.agency.travel.dao.UserDao;
import by.agency.travel.dao.pool.ConnectionPool;
import by.agency.travel.dao.util.DBUtils;

import static by.agency.travel.dao.util.Constants.*;
import static by.agency.travel.dao.util.PropertiesManager.*;

import by.agency.travel.entity.Role;
import by.agency.travel.entity.User;

public class UserDaoImpl extends AbstractDao<User> implements UserDao{
	private static UserDaoImpl instance;
	private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	
	private UserDaoImpl(){
	}

	public synchronized static UserDaoImpl getInstance(){
		LOGGER.debug("Run getInstance method");
		if(instance == null){
			instance = new UserDaoImpl();
		}
		return instance;
	}

	@Override
	protected void setParameters(String methodName, Statement statement, User object) throws SQLException {
		LOGGER.debug("Run setParameters method");
		if(methodName.equals(METHOD_NAME_CREATE)){
			((PreparedStatement) statement).setString(1, object.getLogin());
			((PreparedStatement) statement).setString(2, object.getPass());
		} else if(methodName.equals(METHOD_NAME_READ)){
			((PreparedStatement) statement).setString(1, object.getLogin());
			((PreparedStatement) statement).setString(2, object.getPass());
		}
	}

	@Override
	protected String getSql(String methodName) {
		LOGGER.debug("Run getSql method");
		if(methodName.equals(METHOD_NAME_CREATE)){
			return SQL_REQUEST.getProperty("sql.create.user");
		} else if(methodName.equals(METHOD_NAME_READ)){
			return SQL_REQUEST.getProperty("sql.read.user");
		} else if(methodName.equals(METHOD_NAME_READ_ALL)){
			return SQL_REQUEST.getProperty("sql.read.all.users");
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	protected User create(ResultSet resultSet) throws SQLException {
		LOGGER.debug("Run create method");
		User user = null;
		if(resultSet.next()){
			user = new User();
			user.setId(resultSet.getInt(PARAM_USER_ID));
			user.setLogin(resultSet.getString(PARAM_USER_LOGIN));
			user.setPass(resultSet.getString(PARAM_USER_PASS));
		}
		return user;
	}

	@Override
	protected List<User> createList(ResultSet resultSet) throws SQLException {
		LOGGER.debug("Run createList method");
		List<User> users = new ArrayList<User>();
		while(resultSet.next()){
			User user = new User();
			user.setId(resultSet.getInt(PARAM_USER_ID));
			user.setLogin(resultSet.getString(PARAM_USER_LOGIN));
			user.setPass(resultSet.getString(PARAM_USER_PASS));
			users.add(user);
		}
		return users;
	}
	
	@Override
	public List<Role> findRoles(int userId){
		LOGGER.debug("Run findRoles method, id=" + userId);
		List<Role> result = null;
		Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
        	connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(SQL_REQUEST.getProperty("sql.read.user.roles"));
			statement.setInt(1, userId);
			resultSet = statement.executeQuery();
			result = createListRoles(resultSet);
        } catch (SQLException e) {
        	LOGGER.error("TechnicalException", e);
        } finally {
            DBUtils.close(connection, statement, resultSet);
        }
        return result;
	}

	@Override
	public void addRole(int userID, int roleId) {
		LOGGER.debug("Run addRole method, userId=" + userID + ", roleId=" + roleId);
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(SQL_REQUEST.getProperty("sql.create.user.role"));
			statement.setInt(1, userID);
			statement.setInt(2, roleId);
			statement.executeUpdate();
		} catch (SQLException e){
			LOGGER.error("TechnicalException", e);
		} finally {
			DBUtils.close(connection, statement);
		}
	}
	
	private List<Role> createListRoles(ResultSet resultSet) throws SQLException{
		LOGGER.debug("Run createListRoles method");
		List<Role> roles = new ArrayList<Role>();
		while(resultSet.next()){
			Role role = new Role();
			role.setId(resultSet.getInt(PARAM_USER_ROLE_ID));
			role.setName(resultSet.getString(PARAM_ROLE_NAME));
			roles.add(role);
		}
		return roles;
	}

}