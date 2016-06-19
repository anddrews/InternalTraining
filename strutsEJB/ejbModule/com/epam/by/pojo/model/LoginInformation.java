package com.epam.by.pojo.model;

import java.io.Serializable;

public class LoginInformation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private boolean isLogin;
	private String attach;

	public LoginInformation(boolean isLogin, String attach) {
		this.isLogin = isLogin;
		this.attach = attach;
	}

	public LoginInformation() {
		super();
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}
	
	
	
	
}
