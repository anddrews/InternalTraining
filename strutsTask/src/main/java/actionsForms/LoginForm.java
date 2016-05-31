package actionsForms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import models.User;

public class LoginForm extends ActionForm{
	private String login;
	private String passw;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}		
	
	public User getUser(){
		return new User(login,passw);
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.login=null;
		this.passw=null;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (login == null || login.trim().isEmpty()) {
			errors.add("login", new ActionMessage("registration.error.login.missing"));
		}
		if (passw == null || passw.trim().isEmpty()) {
			errors.add("passw", new ActionMessage("registration.error.password.missing"));
		}
		return errors;		
	}
	
	
	  	
	
	
}
