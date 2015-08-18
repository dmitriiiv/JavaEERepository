package by.agency.travel.dao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DBUtils {
	private static final Logger LOGGER = Logger.getLogger(DBUtils.class);
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        LOGGER.debug("Run close method");
		try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
        	LOGGER.error("TechnicalException", e);
        }
    }

    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }
}
