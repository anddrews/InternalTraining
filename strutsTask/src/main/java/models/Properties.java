package models;

import java.util.Enumeration;
import java.util.ResourceBundle;

import constants.Constants;

public class Properties {
	
	private static Properties property;

	private Properties() {
	}
	
	private static Properties getProperties(){
	
		return property;
	}
	

	public static String getPathToXml() {
		return "D:\\Reservation.xml";
	}

	public static String getBaseUri() {
		
		return "http://localhost:8080/restService/";
	}
	
	

}
