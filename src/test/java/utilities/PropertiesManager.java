package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private final String PROPERTY_FILE_PATH;
    private Properties prop;

    public PropertiesManager() {
        PROPERTY_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config.properties";
    }

    private void loadData() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(PROPERTY_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String propertyName) {
        loadData();
        return prop.getProperty(propertyName);
    }
}
