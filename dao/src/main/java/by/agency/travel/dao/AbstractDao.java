package by.agency.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import by.agency.travel.dao.exception.DaoException;
import by.agency.travel.dao.pool.ConnectionPool;
import by.agency.travel.dao.util.DBUtils;

import static by.agency.travel.dao.util.Constants.*;

public abstract class AbstractDao<T> implements GenericDao<T> {
	private static final Logger LOGGER = Logger.getLogger(AbstractDao.class);

	@Override
	public boolean create(T object) throws DaoException {
		LOGGER.debug("Run create method, object=" + object);
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
			LOGGER.error("Cannot create" + object, e);
			throw new DaoException("Cannot create " + object, e);
		} finally {
			DBUtils.close(connection, statement);
		}
		LOGGER.debug(object + "was created");
		return isCreated;
	}

	@Override
	public T read(T object) throws DaoException {
		LOGGER.debug("Run read method, object=" + object);
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
        	LOGGER.error("Cannot read " + object, e);
        	throw new DaoException("Cannot read " + object, e);
        } finally {
            DBUtils.close(connection, statement, resultSet);
        }
        LOGGER.debug("Returning " + object);
		return result;
	}

	@Override
	public List<T> readAll() throws DaoException {
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
        	LOGGER.error("Cannot read all", e);
        	throw new DaoException("Cannot read all", e);
        } finally {
            DBUtils.close(connection, statement, resultSet);
        }
        LOGGER.debug("Read all good");
        return result;
	}
	
	protected abstract void setParameters(String methodName, Statement statement, T object) throws SQLException;

	protected abstract String getSql(String methodName);
	
	protected abstract T create(ResultSet resultSet) throws SQLException;
	
	protected abstract List<T> createList(ResultSet resultSet) throws SQLException;
	
}

