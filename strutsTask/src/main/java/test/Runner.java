package test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import com.epam.by.IFacesHome.ReservationEJBHome;
import com.epam.by.IFacesRemote.ReservationEJB;
import com.epam.by.pojo.model.reservation.Reservation;

import bll.EjbContext;
import constants.Constants;

public class Runner {

	public static void main(String[] args) {
		Reservation result=null;
		
		// preparing properties for constructing an InitialContext object
				Properties properties = new Properties();
				properties.put(Context.INITIAL_CONTEXT_FACTORY,
						"org.jnp.interfaces.NamingContextFactory");
				properties.put(Context.PROVIDER_URL, "jnp://localhost:1099"); 
				try {
					// Get an initial context
					InitialContext jndiContext = new InitialContext(properties);
					System.out.println("Got context");

					// Get a reference to the Bean
					Object ref = jndiContext.lookup("Adder");
					System.out.println("Got reference");

					// Get a reference from this to the Bean's Home interface
					ReservationEJBHome home = (ReservationEJBHome) PortableRemoteObject.narrow(ref,
							ReservationEJBHome.class);
					ReservationEJB logicEjb = home.create();
					result=logicEjb.getReservation();
					System.out.println(result);
				} catch (Exception e) {
					e.printStackTrace(); 
				}	
		
		
	}

}
