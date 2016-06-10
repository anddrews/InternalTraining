package bll;

import com.epam.by.pojo.model.LoginInformation;

import interfaces.ILogic;

public class Logic implements ILogic{

	public LoginInformation checkLogin(String login, String passw) {
		
		return new LoginInformation("user".equals(login)&&"user".equals(passw),"");
	}

	
	
	
}
