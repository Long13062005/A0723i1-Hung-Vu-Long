package Repo.imp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Person.Customer;
import Model.Person.Employee;
import Repo.IRepository;
import Repo.Interface.ICustomerRepository;
import Util.ReadAndWriteFileCSV;

public class CustomerRepository implements ICustomerRepository {
	
	 private final String CUSTOMER_FILE ="src/Data/Person/Customer.csv";

	@Override
	public List<Customer> getAll() {
		List<String> stringList = new ArrayList<>();
        stringList= ReadAndWriteFileCSV.readFileCSV(CUSTOMER_FILE);
        List<Customer> customerList = new ArrayList<>();
        String[] array = null;
        for (String line: stringList) {
            array = line.split(",");
            Customer customer = new Customer(array[0],array[1], array[2], array[3], array[4], array[5],array[6], array[7], array[8]);
            customerList.add(customer);
        }
        return customerList;
	}

	@Override
	public List<Customer> update(Customer updateCustomer) {
		List<Customer> customers = getAll();

	    // Find the index of the employee to be updated based on their ID
	    int index = -1;
	    for (int i = 0; i < customers.size(); i++) {
	        if (customers.get(i).getMaNhanVien() == updateCustomer.getMaNhanVien()) {
	            index = i;
	            break;
	        }
	    }

	    if (index != -1) {
	        // Update the employee's information
	        customers.set(index, updateCustomer);

	        // Save the updated list back to the file
	        List<String> stringList = new ArrayList<>();
	        for (Customer c : customers) {
	            stringList.add(c.getInfoToCSV());
	        }
	        ReadAndWriteFileCSV.writeListStringToCSV(CUSTOMER_FILE, stringList, false);

	        System.out.println("Cập nhật thành công");
	    } else {
	        System.out.println("Không tìm thấy nhân viên để cập nhật");
	    }

	    return customers;
	}

	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		 List<String> stringList = new ArrayList<>();
	        stringList.add(customer.getInfoToCSV());
	        ReadAndWriteFileCSV.writeListStringToCSV(CUSTOMER_FILE,stringList,true);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		List<Customer> c = getAll();
		List<String> stringList = new ArrayList<>() ;
		for (int i = 0;i < c.size();i++) {
			if ( c.get(i).getMaNhanVien()!=id){
                stringList.add(c.get(i).getInfoToCSV());
            }
		}
		ReadAndWriteFileCSV.writeListStringToCSV(CUSTOMER_FILE,stringList,false);
        if (c.size()!=stringList.size()){
            System.out.println("xoá thành công");
        }else {
            System.out.println("Xoá không thành công");
        }
	}

}
