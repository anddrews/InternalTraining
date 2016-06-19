package com.epam.by.IFacesHome;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

import com.epam.by.IFacesRemote.LogicEJB;

public interface LogicEJBHome  extends EJBHome {
	LogicEJB create() throws RemoteException, CreateException;
}
