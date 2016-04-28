package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Passendger {
	private String firstName;
	private String lastName;
	private String city;
	private String street;
	private int house;

	public Passendger(String firstName, String lastName, String city, String street, int house) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.street = street;
		this.house = house;
	}	

	public Passendger() {
		this.firstName = "";
		this.lastName = "";
		this.city = "";
		this.street = "";
		this.house = 0;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouse() {
		return house;
	}

	public void setHouse(int house) {
		this.house = house;
	}

	@Override
	public String toString() {
		return "[firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", street=" + street
				+ ", house=" + house + "]";
	}
	
	
	
}
