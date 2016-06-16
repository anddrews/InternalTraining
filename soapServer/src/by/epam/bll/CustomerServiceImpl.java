package by.epam.bll;

import java.util.List;

import javax.jws.WebService;

import by.epam.interfaces.CustomersService;
import by.epam.model.Customer;

@WebService(endpointInterface = "by.epam.interfaces.CustomersService")
public class CustomerServiceImpl implements CustomersService{
	private Dao dao=new Dao();

	@Override
	public List<Customer> getAllCustomer() {
		return dao.getAllCustomer();
	}

	@Override
	public Customer getCustomerById(int id) {
		return dao.getCustomerById(id);
	}

	@Override
	public boolean addNewCustomer(Customer newCustomer) {
		return dao.addNewCustomer(newCustomer);
	}

	@Override
	public boolean removeCustomerById(int id) {
		return dao.removeCustomerById(id);
	}

	@Override
	public boolean updateCustomer(int id, String name, String phone, String eMail) {
		return dao.updateCustomer(id, name, phone, eMail);
	}

}
