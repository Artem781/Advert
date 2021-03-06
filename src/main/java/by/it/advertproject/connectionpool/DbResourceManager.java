package by.it.advertproject.connectionpool;

import java.util.ResourceBundle;

class DbResourceManager {
    static final String DB_PROPERTY_PATH = "db";
    private final static DbResourceManager instance = new DbResourceManager();

    private ResourceBundle bundle = ResourceBundle.getBundle(DB_PROPERTY_PATH);

    static DbResourceManager getInstance() {
        return instance;
    }

    String getValue(String key) {
        return bundle.getString(key);
    }
}
