package Repo;

import java.util.List;
import java.util.Set;

import Model.Person.Customer;
import Model.Person.Employee;

public interface IRepository<T> {
	   List<T> getAll();
	    List<T> update(T t);
	    void add(T t);
		void delete(String id);

}
