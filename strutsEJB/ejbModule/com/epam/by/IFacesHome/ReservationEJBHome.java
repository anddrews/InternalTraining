package com.epam.by.IFacesHome;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

import com.epam.by.IFacesRemote.ReservationEJB;

public interface ReservationEJBHome  extends EJBHome {
	ReservationEJB create() throws RemoteException, CreateException;
}
