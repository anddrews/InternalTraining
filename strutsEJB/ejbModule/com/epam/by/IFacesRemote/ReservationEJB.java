package com.epam.by.IFacesRemote;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

import com.epam.by.pojo.model.reservation.Reservation;

public interface ReservationEJB extends EJBObject {
	Reservation getReservation() throws RemoteException;
}
