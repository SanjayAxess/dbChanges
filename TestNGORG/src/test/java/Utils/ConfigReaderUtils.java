package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderUtils {
    private Properties properties;

    public ConfigReaderUtils() {
        try {
            String src = "src/test/resources/Configuration/Config.Properties";
            FileInputStream fileInputStream = new FileInputStream(src);
            // Load the properties file
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    // Method to get property value by key
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
