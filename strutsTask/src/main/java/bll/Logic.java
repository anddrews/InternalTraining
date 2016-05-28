package bll;

import interfaces.ILogic;

public class Logic implements ILogic{

	public boolean checkLogin(String login, String password) {		
		return "user".equals(login)&&"user".equals(password);
	}
	
	
}
