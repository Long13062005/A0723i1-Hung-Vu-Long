package Service.imp;

import java.util.List;
import java.util.Set;

import Model.Booking;
import Model.Person.Customer;
import Repo.Interface.ICustomerRepository;
import Repo.imp.CustomerRepository;
import Service.Interface.ICustomerService;

public class CustomerService implements ICustomerService {
		private ICustomerRepository cusRepo = new CustomerRepository();
	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
				List<Customer> listCus = cusRepo.getAll();
				for(Customer b : listCus) {
					System.out.println(b);
				}
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editByID() {
		// TODO Auto-generated method stub
		
	}

}
