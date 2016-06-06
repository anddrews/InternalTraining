package bll;

import interfaces.ILogic;

public class Logic implements ILogic{

	public boolean checkLogin(String login, String passw) {		
		return "user".equals(login)&&"user".equals(passw);
	}

	
	
	
}
