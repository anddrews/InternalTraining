package models;

import java.util.Enumeration;
import java.util.ResourceBundle;

import constants.Constants;

public class Properties {
	
	private static Properties property;

	private Properties() {
//		this.property = property;
	}
	
	private static Properties getProperties(){
		
		if(property==null)
		{
			ResourceBundle resourcesBundle=ResourceBundle.getBundle(Constants.PROPERTY_PATH);
	        Enumeration<String> resourcesKey=resourcesBundle.getKeys();
//	        while (resourcesKey.hasMoreElements())
//	        {
//	            String key=resourcesKey.nextElement();
//	            if (key.compareTo(DB_URL)==0){dbUrl=resourcesBundle.getString(key).trim();}
//	            if (key.compareTo(PASSWORD)==0){password=resourcesBundle.getString(key).trim();}
//	            if (key.compareTo(USER)==0){user=resourcesBundle.getString(key).trim();}
//	            if (key.compareTo(DRIVER)==0){driver=resourcesBundle.getString(key).trim();}
//	        }
	//
//	            Class.forName(driver);
//	            connection= DriverManager.getConnection(dbUrl,user,password);
		}
		return property;
	}
	

	public static String getPathToXml() {
		return null;
	}
	
	

}
