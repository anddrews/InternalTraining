package com.epam.by.pojo.model.reservation;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="FareFamily")
@XmlAccessorType(XmlAccessType.FIELD)
public class FareFamily implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="FareFamilyCode")
	private String fareFamilyCode;
	@XmlElements(value = { @XmlElement(name="AncillaryAirComponent") })
	private List<AncillaryAirComponent> ancillaryComponents;

	public FareFamily() {
	}

	public FareFamily(String fareFamilyCode, List<AncillaryAirComponent> ancillaryComponents) {
		this.fareFamilyCode = fareFamilyCode;
		this.ancillaryComponents = ancillaryComponents;
	}

	@Override
	public String toString() {
		return "\nFareFamily [fareFamilyCode=" + fareFamilyCode + ", ancillaryComponents=" + ancillaryComponents + "]";
	}

	public String getFareFamilyCode() {
		return fareFamilyCode;
	}

	public void setFareFamilyCode(String fareFamilyCode) {
		this.fareFamilyCode = fareFamilyCode;
	}

	public List<AncillaryAirComponent> getAncillaryComponents() {
		return ancillaryComponents;
	}

	public void setAncillaryComponents(List<AncillaryAirComponent> ancillaryComponents) {
		this.ancillaryComponents = ancillaryComponents;
	}
	

		
	
}
