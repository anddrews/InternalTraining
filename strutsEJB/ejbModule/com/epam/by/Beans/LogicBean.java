 package com.epam.by.Beans;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.epam.by.pojo.IFaces.IDao;
import com.epam.by.pojo.fabric.FabricDao;
import com.epam.by.pojo.model.LoginInformation;
import com.epam.by.pojo.model.UserEntity;

@SuppressWarnings("serial")
public class LogicBean implements SessionBean  {


	public LoginInformation checkLogin(String login, String passw) {
		LoginInformation result=new LoginInformation();
		IDao dao=new FabricDao().getDao();
		UserEntity user=dao.getUser(login, passw);
		if(!"".equals(user.getLogin())){
			result.setLogin(true);
		}
		else{
			result.setLogin(false);
			result.setAttach(user.getAttachInformation());
		}
		return result;
	}

	public void ejbCreate() {
	}	
	
	public void ejbActivate() throws EJBException, RemoteException {
	}

	public void ejbPassivate() throws EJBException, RemoteException {		
	}

	public void ejbRemove() throws EJBException, RemoteException {		
	}

	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {	
	}
	
}
