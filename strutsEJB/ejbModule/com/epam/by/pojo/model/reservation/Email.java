package com.epam.by.pojo.model.reservation;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Email")
@XmlAccessorType(XmlAccessType.FIELD)
public class Email implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="EmailAddress")
	private String email;

	public Email() {
	}

	public Email(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nEmail [email=" + email + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
