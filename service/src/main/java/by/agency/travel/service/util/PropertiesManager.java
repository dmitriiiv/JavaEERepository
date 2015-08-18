package by.agency.travel.service.util;

import java.util.ResourceBundle;

public enum PropertiesManager {
	MESSAGE {
		@Override
		public String getProperty(String key) {
			return ResourceBundle.getBundle("by.agency.travel.service.messages").getString(key);
		}
	};
	
	public abstract String getProperty(String key);
}
