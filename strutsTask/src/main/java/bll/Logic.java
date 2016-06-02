package bll;

import interfaces.ILogic;
import models.User;

public class Logic implements ILogic{

	public boolean checkLogin(String login, String passw) {		
		return "user".equals(login)&&"user".equals(passw);
	}

	public boolean isCanMove(boolean isUser, String refer) {
		boolean result=false;
		
		return result;
	}
	
	
}
