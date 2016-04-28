package model;

import java.text.ParseException;
import java.util.logging.Logger;

public class Book {
	private int id;
	private Passendger passendger;
	private Place origin;
	private Place destination;
	
	public Book(int id, Passendger passendger, Place origin, Place destination) {
		this.id = id;
		this.passendger = passendger;
		this.origin = origin;
		this.destination = destination;
	}

	public Book() {
		this.id = 0;
		this.passendger = new Passendger();		
		this.origin = null;
		this.destination = null;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Passendger getPassendger() {
		return passendger;
	}

	public void setPassendger(Passendger passendger) {
		this.passendger = passendger;
	}

	public Place getOrigin() {
		return origin;
	}

	public void setOrigin(String place, String dateTime){
		Logger log=Logger.getLogger(getClass().toString());
		try {
			this.origin=new Place(place,dateTime);
		} catch (ParseException e) {			
			log.info("Bad input data in origin place for book id= "+ this.id+
					"bad data string:"+dateTime);
			e.printStackTrace();
		}
	}

	public Place getDestination() {
		return destination;
	}
	
	public void setDestination(String place, String dateTime){
			Logger log=Logger.getLogger(getClass().toString());
			try {
				this.destination=new Place(place,dateTime);
			} catch (ParseException e) {
				log.info("Bad input data in destination place for book id= "+ this.id+
						"bad data string:"+dateTime);
				e.printStackTrace();
			}
	}
	
	public void setFirstName(String firstName){
		this.passendger.setFirstName(firstName);
	}
	
	public void setLastName(String lastName){
		this.passendger.setLastName(lastName);
	}
	
	public void setCity(String city){
		this.passendger.setCity(city);
	}
	
	public void setStreet(String street){
	this.passendger.setStreet(street);
	}
	
	public void setHouse(int house){
		this.passendger.setHouse(house);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + " "+ this.passendger+"\n"+
	"origin:"+this.origin+"\n"+"destination:"+ this.destination+"]";
	}
	
	
	
	
	
	
}
