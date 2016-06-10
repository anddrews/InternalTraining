package com.epam.by.restService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.epam.by.bll.Data;
import com.epam.by.model.Reservation;



@Path("simpleservice")
public class Service
{
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Reservation> getAllResrvation() {
		List<Reservation> resevations = Data.getData();
		if (resevations == null) {
			throw new RuntimeException("Can't load all Customers");
		}
		return resevations; 
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Reservation getReservationById(@PathParam("id") long id) {
		Reservation reservation = Data.findCustomerById(id);
		if (reservation == null) {
			throw new RuntimeException("can't find mesage with id = " + id);
		}
		return reservation;
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void addReservation(JAXBElement<Reservation> Customer) {
		if (Data.addCustomer(Customer.getValue()) != true) {
			throw new RuntimeException("can't add mesage with id = "
					+ Customer.getValue().getId());
		}
	}
	
	@DELETE
	@Path("{id}")
	public void deleteReservation(@PathParam("id") int id) {
		if (Data.deleteCustomerById(id) != true) {
			//throw new RuntimeException("can't delete mesage with id = " + id);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void updateReservation(JAXBElement<Reservation> reservation) {
		if (Data.updateCustomer(reservation.getValue()) != true) {
			throw new RuntimeException("can't update mesage with id = "
					+ reservation.getValue().getId());
		}
	}
}