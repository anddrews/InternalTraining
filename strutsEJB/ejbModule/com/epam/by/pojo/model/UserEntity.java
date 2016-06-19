package com.epam.by.pojo.model;

public class UserEntity {
	private String login;
	private String attachInformation;

	public UserEntity(String login) {
		this.login = login;
	}

	public UserEntity() {
		this.login = "";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	@Override
	public String toString() {
		return "login:"+login;
	}

	public String getAttachInformation() {
		return attachInformation;
	}

	public void setAttachInformation(String attachInformation) {
		this.attachInformation = attachInformation;
	}
	
	
	
	
	
}
