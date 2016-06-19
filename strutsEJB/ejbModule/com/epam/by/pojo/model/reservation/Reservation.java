package com.epam.by.pojo.model.reservation;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
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


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<ResComponent> getResComponents() {
		return resComponents;
	}


	public void setResComponents(List<ResComponent> resComponents) {
		this.resComponents = resComponents;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public FareFamily getFareFamily() {
		return fareFamily;
	}


	public void setFareFamily(FareFamily fareFamily) {
		this.fareFamily = fareFamily;
	}		
	
}
