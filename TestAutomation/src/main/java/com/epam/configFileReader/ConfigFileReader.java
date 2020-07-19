package com.epam.configFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private String userName;
	private String password;
	private String url;
	private String browser;

	private Properties properties;
	private final String propertyFilePath = "resources\\config.properties";

	public ConfigFileReader() {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
				
				this.userName = properties.getProperty("username");
				this.password = properties.getProperty("password");
				this.url = properties.getProperty("url");
				this.browser = properties.getProperty("browser");
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}

	}

	public String getUserName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUrl() {
		return this.url;
	}

	
	public String getBrowser() {
		return this.browser;
	}

}
