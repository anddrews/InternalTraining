package by.epam.bll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import by.epam.model.Customer;

public class Dao {
	
	private List<Customer> customers;
	private static int nextIndex=7; 
	
	{
		customers=new ArrayList();
		customers.add(new Customer(1,"John","11-22-33","John@mail.ru"));
		customers.add(new Customer(2,"Peter","11-22-33","Peter@mail.ru"));
		customers.add(new Customer(3,"Andy","11-22-33","Andy@mail.ru"));
		customers.add(new Customer(4,"Simona","11-22-33","Simona@mail.ru"));
		customers.add(new Customer(5,"Mohamad","11-22-33","Mohamad@mail.ru"));
		customers.add(new Customer(6,"Jery","11-22-33","Jery@mail.ru"));
	}
	
	public List<Customer> getAllCustomer(){
		return customers;
	}
	
	public Customer getCustomerById(int id){
		Customer result=new Customer();
		Iterator<Customer> iter = customers.iterator();
		for(Customer tmp:customers){
			if(tmp.getId()==id){
				result=tmp;
			}
		}
		return result;
	}
	
	public boolean addNewCustomer(Customer newCustomer){
		newCustomer.setId(nextIndex++);
		return customers.add(newCustomer);
	}
	
	public boolean removeCustomerById(int id){
		boolean result=false;
		Iterator<Customer> iter=customers.iterator();
		while(iter.hasNext()){
			if(iter.next().getId()==id){
				iter.remove();
				result=true;
			}
		}
		return result;
	}
	
	public boolean updateCustomer(int id, String name, String phone, String eMail){
		boolean result=false;
		for(Customer tmp:customers){
			if(tmp.getId()==id){
				tmp.setName(name);
				tmp.setPhone(phone);tmp.seteMail(eMail);
				result=true;
			}
		}
		return result;
	}
}
