package bll;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import models.Reservation;


public class RestMethods {
	
	public static List<Reservation> getAllReservation(WebResource sourse){
		List<Reservation> reservations = null;
		GenericType<List<Reservation>> genericType = new GenericType<List<Reservation>>(){};
		reservations = sourse.path("webresources").path("simpleservice")
				.accept(MediaType.APPLICATION_XML).get(genericType);
		return reservations;
	}
	
	public static Reservation getReservationById(WebResource sourse, int id){
		Reservation reservations = null;
		reservations = sourse.path("webresources").path("simpleservice").path(String.valueOf(id))
				.accept(MediaType.APPLICATION_XML).get(Reservation.class);
		return reservations;
	}
	
	public static Reservation updateReservation(WebResource service, int id,Reservation reservation){
		service.path("webresources").path("simpleservice").post(reservation);
		reservation = service.path("webresources").path("simpleservice").path(String.valueOf(id))
				.accept(MediaType.APPLICATION_XML).get(Reservation.class);
		return reservation;
	}
	
	public static List<Reservation> deleteReservation(WebResource service, int id){
		service.path("webresources").path("simpleservice").path(String.valueOf(id)).delete();
		List<Reservation> reservations = getAllReservation(service);
		return reservations;
	}
	public static List<Reservation> addReservation(WebResource service, Reservation reservation){
		service.path("webresources").path("simpleservice")
				.accept(MediaType.APPLICATION_XHTML_XML).put(reservation);
		GenericType<List<Reservation>> genericType = new GenericType<List<Reservation>>() {	};
		List<Reservation> reservations = service.path("webresources").path("simpleservice").accept(MediaType.APPLICATION_XML).get(genericType);
		return reservations;
	}
}
