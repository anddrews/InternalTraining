package com.epam.by.bll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.by.model.Reservation;
import com.epam.by.model.Reservation.Customer;

public class Data {
	private static List<Reservation> data;
	private static int newIndex=5;
	static {
		data = new ArrayList<Reservation>();
		data.add(new Reservation(1, new Customer("534-34-23","blablabla@mail.ru")));
		data.add(new Reservation(2, new Customer("13-34-54","gagga@mail.ru")));
		data.add(new Reservation(3, new Customer("33-44-55","google@mail.ru")));
		data.add(new Reservation(4, new Customer("54-55-32","super@mail.ru")));
	}
	
	public static List<Reservation> getData() {
		return data;
	}
	
	public static Reservation findCustomerById(long id) {
		for (Reservation reservation : data) {
			if (reservation.getId() == id) {
				return reservation;
			}
		}
		return null;
	}
	
	
	public static boolean addCustomer(Reservation reservation) {
		reservation.setId(newIndex);
		newIndex++;
		return data.add(reservation);
	}
	
	public static boolean deleteCustomerById(int id) {
		boolean result = false;		
		Iterator<Reservation> iter=data.iterator();
		while(iter.hasNext()){
			if(iter.next().getId()==id){
				iter.remove();
				result=true;
			}
		}
		return result;
	}
	
	public static boolean updateCustomer(Reservation reservation) {
		boolean result = false;
		for (Reservation temp: data) {
			if (temp.getId() == reservation.getId()) {
				temp.setCustomer(reservation.getCustomer());
				result = true;
			}
		}
		return result;
	}
}