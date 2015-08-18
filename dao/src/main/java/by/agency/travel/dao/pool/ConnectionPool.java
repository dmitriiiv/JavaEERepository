package by.agency.travel.dao.pool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import static by.agency.travel.dao.util.PropertiesManager.*;

public class ConnectionPool {
	private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
	private static ConnectionPool instance;
    private BasicDataSource dataSource;

    private ConnectionPool() {
    	LOGGER.debug("Run ConnectionPool method");
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(POOL.getProperty("db.driver"));
        dataSource.setUrl(POOL.getProperty("db.url"));
        dataSource.setUsername(POOL.getProperty("db.user"));
        dataSource.setPassword(POOL.getProperty("db.pass"));
    }

    public synchronized static ConnectionPool getInstance() {
    	LOGGER.debug("Run getInstance method");
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
    	LOGGER.debug("Run getConnection method");
        return dataSource.getConnection();
    }
}
