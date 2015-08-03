package by.agency.travel.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.agency.travel.dao.AbstractDao;
import static by.agency.travel.dao.util.PropertiesManager.*;
import static by.agency.travel.dao.util.Constants.*;
import by.agency.travel.entity.Role;

public class RoleDaoImpl extends AbstractDao<Role>{
	private static RoleDaoImpl instance;
	
	private RoleDaoImpl(){
	}
	
	public synchronized static RoleDaoImpl getInstance(){
		if(instance == null){
			instance = new RoleDaoImpl();
		}
		return instance;
	}

	@Override
	protected void setParameters(String methodName, Statement statement, Role object) throws SQLException {
		if(methodName.equals(METHOD_NAME_CREATE)){
			((PreparedStatement) statement).setString(1, object.getName());
		} else if(methodName.equals(METHOD_NAME_READ)){
			((PreparedStatement) statement).setInt(1, object.getId());
		}
	}

	@Override
	protected String getSql(String methodName) {
		if(methodName.equals(METHOD_NAME_CREATE)){
			return SQL_REQUEST.getProperty("sql.create.role");
		} else if(methodName.equals(METHOD_NAME_READ)){
			return SQL_REQUEST.getProperty("sql.read.role");
		} else if(methodName.equals(METHOD_NAME_READ_ALL)){
			return SQL_REQUEST.getProperty("sql.read.all.roles");
		} else {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	protected Role create(ResultSet resultSet) throws SQLException {
		Role role = new Role();
		resultSet.next();
		role.setId(resultSet.getInt(PARAM_ROLE_ID));
		role.setName(resultSet.getString(PARAM_ROLE_NAME));
		return role;
	}

	@Override
	protected List<Role> createList(ResultSet resultSet) throws SQLException {
		List<Role> roles = new ArrayList<Role>();
		while(resultSet.next()){
			Role role = new Role();
			role.setId(resultSet.getInt(PARAM_ROLE_ID));
			role.setName(resultSet.getString(PARAM_ROLE_NAME));
			roles.add(role);
		}
		return roles;
	}

}

