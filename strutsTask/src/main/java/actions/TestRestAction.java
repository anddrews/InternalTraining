package actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import bll.RestMethods;
import models.Properties;
import models.Reservation;
import models.Reservation.Customer;

public class TestRestAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(Properties.getBaseUri());
		
		/**Get list of customers*/
		List<Reservation> reservations = null;			
		reservations = RestMethods.getAllReservation(service);
		request.setAttribute("allReservation", reservations);
		
		/**Get customer for id*/
		Reservation reservation;
		int id = 3;
		reservation = RestMethods.getReservationById(service, id);
		request.setAttribute("ReservationById", reservation);
		 
		/**Add new customer*/
		Reservation reservationForAdd = new Reservation();
		reservationForAdd.setCustomer(new Customer("111-111-11","newEmail@mail.ru"));
		reservations = RestMethods.addReservation(service, reservationForAdd);
		request.setAttribute("ReservationAdd", reservations);
		
		/**Update customer*/
		id =3;
		Reservation resForUpdate = new Reservation();
		resForUpdate.setCustomer(new Customer("444-44-44","upEmail@mail.ru"));
		resForUpdate.setId(id);
		RestMethods.updateReservation(service, id,resForUpdate);
		reservations = RestMethods.getAllReservation(service);
		request.setAttribute("ReservationAfterUpdate", reservations);
		request.setAttribute("updateId", id);
		
		/**Delete customer*/
		id = 1;
		List<Reservation> reservationsDel = reservations;
		reservationsDel = RestMethods.deleteReservation(service, id);
		request.setAttribute("ReservationDelete", reservationsDel);
		request.setAttribute("deleteId", id);
		
		
		return mapping.findForward("success");
	}
	
	
}
