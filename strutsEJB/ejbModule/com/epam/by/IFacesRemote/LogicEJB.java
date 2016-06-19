package com.epam.by.IFacesRemote;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

import com.epam.by.pojo.model.LoginInformation;

public interface LogicEJB extends EJBObject {
	LoginInformation checkLogin(String login, String passw) throws RemoteException;
}
