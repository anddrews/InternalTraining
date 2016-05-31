package bll;

import interfaces.ILogic;
import models.User;

public class Logic implements ILogic{

	public boolean checkLogin(User user) {		
		return "user".equals(user.getLogin())&&"user".equals(user.getPassword());
	}

	public boolean isCanMove(boolean isUser, String refer) {
		boolean result=false;
		
		return result;
	}
	
	
}
