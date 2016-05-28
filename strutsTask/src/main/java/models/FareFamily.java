package models;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="FareFamily")
public class FareFamily {
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

		
	
}
