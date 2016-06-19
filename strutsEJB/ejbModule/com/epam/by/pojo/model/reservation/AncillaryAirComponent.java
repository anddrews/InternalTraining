package com.epam.by.pojo.model.reservation;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="AncillaryAirComponent")
@XmlAccessorType(XmlAccessType.FIELD)
public class AncillaryAirComponent implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="AncillaryAirComponentCode")	
	private String ancillaryAirComponentCode;

	public AncillaryAirComponent() {
	}

	public AncillaryAirComponent(String ancillaryAirComponentCode) {
		this.ancillaryAirComponentCode = ancillaryAirComponentCode;
	}

	@Override
	public String toString() {
		return "\nAncillaryAirComponent [ancillaryAirComponentCode=" + ancillaryAirComponentCode + "]";
	}

	public String getAncillaryAirComponentCode() {
		return ancillaryAirComponentCode;
	}

	public void setAncillaryAirComponentCode(String ancillaryAirComponentCode) {
		this.ancillaryAirComponentCode = ancillaryAirComponentCode;
	}
	

	
	
}
