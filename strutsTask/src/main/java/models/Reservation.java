package models;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Reservation")
public class Reservation {
	
	@XmlAttribute(name = "Code")
	private String code;
	@XmlAttribute(name = "Description")
	private String description;	
	@XmlElements(value = { @XmlElement(name="ResComponent") })
	private List<ResComponent> resComponents;
	@XmlElement(name="Customer")
	private Customer customer;
	@XmlElement(name="FareFamily")
	private FareFamily fareFamily;
	
	
	public Reservation(String code, String description) {
	this.code = code;
	this.description = description;
	}
	
	
	public Reservation() {
	}


	@Override
	public String toString() {
		return "Reservation [code=" + code + ", description=" + description + ", resComponents=" + resComponents
				+ ", customer=" + customer + ", fareFamily=" + fareFamily + "]";
	}		
	
}
