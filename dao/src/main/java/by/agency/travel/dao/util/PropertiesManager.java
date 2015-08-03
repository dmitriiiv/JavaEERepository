package by.agency.travel.dao.util;

import java.util.ResourceBundle;

public enum PropertiesManager {
	POOL {
		@Override
		public String getProperty(String key) {
			return ResourceBundle.getBundle("by.agency.travel.dao.dataBase").getString(key);
		}
	},
	SQL_REQUEST {
		@Override
		public String getProperty(String key) {
			return ResourceBundle.getBundle("by.agency.travel.dao.sqlRequests").getString(key);
		}
	},
	MESSAGE {
		@Override
		public String getProperty(String key) {
			return ResourceBundle.getBundle("by.agency.travel.dao.messages").getString(key);
		}
	};
	
	public abstract String getProperty(String key);

}
