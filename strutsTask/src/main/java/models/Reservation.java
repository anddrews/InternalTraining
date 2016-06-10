package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reservation {
	private int id;
	private Customer customer;
	
	public Reservation() {
		
	}
	

	public Reservation(int id ,Customer customer) {
		this.id = id;
		this.customer = customer;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public String getEmail() {
		return this.getCustomer().email;
	}
	
	public String getPhone() {
		return this.getCustomer().phone;
	}
	
	
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", customer=" + customer + "]";
	}


	@XmlRootElement
	public static class Customer {
		private String phone;
		private String email;
		
		
		public Customer() {
			
		}
		
		public Customer(String phone, String email) {
			this.phone = phone;
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Customer [Phone=" + phone + ", Email=" + email + "]";
		}
		
		
	}
}