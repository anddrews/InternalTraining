package com.epam.by.Beans;

import java.io.File;
import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.epam.by.pojo.IFaces.IDao;
import com.epam.by.pojo.fabric.FabricDao;
import com.epam.by.pojo.model.Properties;
import com.epam.by.pojo.model.UserEntity;
import com.epam.by.pojo.model.reservation.Reservation;

@SuppressWarnings("serial")
public class ReservationBean implements SessionBean  {


	public Reservation getReservation() {
		Reservation result=new Reservation(); 
		try {
			 	File file = new File(Properties.getPathToXml());
				JAXBContext jaxbContext = JAXBContext.newInstance(Reservation.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				result = (Reservation) jaxbUnmarshaller.unmarshal(file);

			  } catch (JAXBException e) {
				e.printStackTrace();
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
