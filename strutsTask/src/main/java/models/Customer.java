package models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	@XmlAttribute(name="CustomerDocID")
	private String name;
	@XmlElement(name="Email")
	private Email email;
	@XmlElement(name="Phone")
	private Phone phone;
	@XmlElements(value = { @XmlElement(name="Payment") })	
	private List<Payment> paiments;	
	
	
	public Customer() {
	}



	public Customer(String name, Email email, Phone phone, List<Payment> paiments) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.paiments = paiments;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Email getEmail() {
		return email;
	}



	public void setEmail(Email email) {
		this.email = email;
	}



	public Phone getPhone() {
		return phone;
	}



	public void setPhone(Phone phone) {
		this.phone = phone;
	}



	public List<Payment> getPaiments() {
		return paiments;
	}



	public void setPaiments(List<Payment> paiments) {
		this.paiments = paiments;
	}



	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", phone=" + phone + ", paiments=" + paiments + "]";
	}

	
	
	
}
