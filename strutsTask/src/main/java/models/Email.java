package models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Email")
public class Email {
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

	
}
