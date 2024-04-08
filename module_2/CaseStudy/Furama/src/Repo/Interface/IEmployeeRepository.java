package Repo.Interface;

import java.util.List;

import Model.Person.Employee;
import Repo.IRepository;

public interface IEmployeeRepository extends IRepository<Employee>{
	List<Employee> searchEmp(String title);
	
	Employee searchEmp(int empID);
	
}
