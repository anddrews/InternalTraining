package bll;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import constants.Constants;

public class EjbContext {
	
	
	public Context getContext(){
		Context context=null;
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,Constants.INITIAL_CONTEXT_FACTORY);
		properties.put(Context.PROVIDER_URL, Constants.PROVIDER_URL);
		try {
			context = new InitialContext(properties);			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return context;
	}
}
