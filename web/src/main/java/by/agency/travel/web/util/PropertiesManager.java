package by.agency.travel.web.util;

import java.util.ResourceBundle;

public enum PropertiesManager {
    PAGE {
        @Override
        public String getProperty(String key) {
            return ResourceBundle.getBundle("by.agency.travel.web.PageConfig").getString(key);
        }
    },
    ERROR_MESSAGE {
        @Override
        public String getProperty(String key) {
            return ResourceBundle.getBundle("by.agency.travel.web.ErrorMessage").getString(key);
        }
    };

    public abstract String getProperty(String key);
}
