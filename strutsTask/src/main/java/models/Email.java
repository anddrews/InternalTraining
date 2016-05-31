package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Email")
@XmlAccessorType(XmlAccessType.FIELD)
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
