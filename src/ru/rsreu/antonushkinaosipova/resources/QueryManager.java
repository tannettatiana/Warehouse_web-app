package ru.rsreu.antonushkinaosipova.resources;

import java.util.ResourceBundle;

public class QueryManager {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.queries");
	private QueryManager() {	}
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
