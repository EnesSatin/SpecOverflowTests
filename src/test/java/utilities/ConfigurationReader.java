package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    // This class reads the information in the configuration.properties file.

    static Properties properties;

    static {
        String path = "configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();

            properties.load(file);
        } catch (Exception e) {
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
