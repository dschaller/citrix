package framework;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private final Properties properties;
	
	public Configuration() {
		try {
			properties = new Properties();
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
			properties.load(inputStream);
			inputStream.close();
		} catch (Exception e) {
				throw new RuntimeException("Could not open property file: " + PROPERTY_FILE_NAME);
		}
	}
	
	public String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}
	
	private static final String PROPERTY_FILE_NAME = "config.properties";
}
