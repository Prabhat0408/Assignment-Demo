package helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



import enums.DriverType;

public class ConfigFileReader {

	private static final String configFilePath = "config/config.properties";
	private static Properties properties = new Properties();
	private static ConfigFileReader instance;

	static {
		try {
			properties = loadProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * private ConfigFileReader() {}
	 * 
	 * public static ConfigFileReader getInstance() {
	 * 
	 * if(instance == null) { instance = new ConfigFileReader(); } return instance;
	 * 
	 * 
	 * }
	 */
	 

	public static Properties loadProperties() throws IOException, FileNotFoundException {

		// The below logic gets the file from
		// src/test/resources/config/configuration.properties.
		InputStream inputstream = ConfigFileReader.class.getClassLoader().getResourceAsStream(configFilePath);

		try {
			properties.load(inputstream);
			inputstream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static DriverType getBrowserType() {
		String browserName;
		if (System.getProperty("BROWSER") != null) {
			browserName = System.getProperty("BROWSER");
		} else {
			browserName = properties.getProperty("browserType");
		}
		if (browserName == null || browserName.equalsIgnoreCase("chrome")) {
			return DriverType.CHROME;
		} else if (browserName.equalsIgnoreCase("firefox")) {
			return DriverType.FIREFOX;
		} else {
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
		}
	}

	public static String getHomePageURL() {
		return properties.getProperty("homePageURL");
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}

}
