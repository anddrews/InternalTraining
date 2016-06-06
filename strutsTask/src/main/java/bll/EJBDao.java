package bll;

import javax.naming.Context;
import javax.rmi.PortableRemoteObject;

import com.epam.by.IFacesHome.ReservationEJBHome;
import com.epam.by.IFacesRemote.ReservationEJB;
import com.epam.by.pojo.model.reservation.Reservation;

import interfaces.IDao;

public class EJBDao implements IDao {
	
	public EJBDao() {
	}

	public Reservation getReservation() {
		Reservation result=null;		
		try {
			Context jndiContext = new EjbContext().getContext();
			Object ref = jndiContext.lookup("ReservationEJBName");
			ReservationEJBHome home = (ReservationEJBHome) PortableRemoteObject.narrow(ref,
					ReservationEJBHome.class);
			ReservationEJB logicEjb = home.create();
			result=logicEjb.getReservation();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		return result;
	}

}
