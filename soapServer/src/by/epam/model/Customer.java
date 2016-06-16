package by.epam.model;

public class Customer {
	
	private int id;
	private String name;
	private String phone;
	private String eMail;
	

	
	
	public Customer() {
	}

	public Customer(int id,String name, String phone, String eMail) {
		this.id=id;
		this.name = name;
		this.phone = phone;
		this.eMail = eMail;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
	
	
	
}

