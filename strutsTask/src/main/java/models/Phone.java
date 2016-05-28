package models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Phone")
public class Phone {
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
	
	
	

	

}
