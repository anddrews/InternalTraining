package models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="AncillaryAirComponent")
public class AncillaryAirComponent {
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

	
	
}
