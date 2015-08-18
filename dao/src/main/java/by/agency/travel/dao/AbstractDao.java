package by.agency.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import by.agency.travel.dao.pool.ConnectionPool;
import by.agency.travel.dao.util.DBUtils;

import static by.agency.travel.dao.util.Constants.*;

public abstract class AbstractDao<T> implements GenericDao<T> {
	private static final Logger LOGGER = Logger.getLogger(AbstractDao.class);

	@Override
	public boolean create(T object) {
		LOGGER.debug("Run create method");
		Connection connection = null;
		PreparedStatement statement = null;
		boolean isCreated = false;
		try{
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(getSql(METHOD_NAME_CREATE));
			setParameters(METHOD_NAME_CREATE, statement, object);
			statement.executeUpdate();
			isCreated = true;
		} catch (SQLException e){
			LOGGER.error("TechnicalException", e);
		} finally {
			DBUtils.close(connection, statement);
		}
		return isCreated;
	}

	@Override
	public T read(T object) {
		LOGGER.debug("Run read method");
		T result = null;
		Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
        	connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(getSql(METHOD_NAME_READ));
			setParameters(METHOD_NAME_READ, statement, object);
			resultSet = statement.executeQuery();
			result = create(resultSet);
        } catch (SQLException e) {
        	LOGGER.error("TechnicalException", e);
        } finally {
            DBUtils.close(connection, statement, resultSet);
        }
		return result;
	}

	@Override
	public List<T> readAll() {
		LOGGER.debug("Run readAll method");
		List<T> result = null;
		Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
        	connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(getSql(METHOD_NAME_READ_ALL));
			result = createList(resultSet);
        } catch (SQLException e) {
        	LOGGER.error("TechnicalException", e);
        } finally {
            DBUtils.close(connection, statement, resultSet);
        }
        return result;
	}
	
	protected abstract void setParameters(String methodName, Statement statement, T object) throws SQLException;

	protected abstract String getSql(String methodName);
	
	protected abstract T create(ResultSet resultSet) throws SQLException;
	
	protected abstract List<T> createList(ResultSet resultSet) throws SQLException;
	
}

