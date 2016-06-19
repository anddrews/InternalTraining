package com.epam.by.pojo.model.reservation;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="PhoneNumber")
	private String phone;

	public Phone() {
	}

	public Phone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "\nPhone [phone=" + phone + "]";
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

	

}
