package Repo.imp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Person.Employee;
import Model.Person.Person;
import Repo.IRepository;
import Repo.Interface.IEmployeeRepository;
import Util.ReadAndWriteFileCSV;

public class EmployeeRepository implements IEmployeeRepository {
	 private final String EMPLOYEE_FILE ="src/Data/Person/Employees.csv";
	@Override
	public List<Employee> getAll() {
		 List<String> stringList = new ArrayList<>();
	        stringList= ReadAndWriteFileCSV.readFileCSV(EMPLOYEE_FILE);
	        List<Employee> employeesList = new ArrayList<>();
	        String[] array = null;
	        for (String line: stringList) {
	            array = line.split(",");
	            Employee employee = new Employee(array[0],array[1], array[2], array[3], array[4], array[5],array[6], array[7], array[8], Integer.parseInt(array[9]));
	            employeesList.add(employee);
	        }
	        return employeesList;
	}


	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		 List<String> stringList = new ArrayList<>();
	        stringList.add(employee.getInfoToCSV());
	        ReadAndWriteFileCSV.writeListStringToCSV(EMPLOYEE_FILE,stringList,true);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		List<Employee> e = getAll();
		List<String> stringList = new ArrayList<>() ;
		for (int i = 0;i < e.size();i++) {
			if ( e.get(i).getMaNhanVien()!=id){
                stringList.add(e.get(i).getInfoToCSV());
            }
		}
		ReadAndWriteFileCSV.writeListStringToCSV(EMPLOYEE_FILE,stringList,false);
        if (e.size()!=stringList.size()){
            System.out.println("xoá thành công");
        }else {
            System.out.println("Xoá không thành công");
        }
	}

	@Override
	public List<Employee> update(Employee updatedEmployee) {
		List<Employee> employees = getAll();

	    // Find the index of the employee to be updated based on their ID
	    int index = -1;
	    for (int i = 0; i < employees.size(); i++) {
	        if (employees.get(i).getMaNhanVien() == updatedEmployee.getMaNhanVien()) {
	            index = i;
	            break;
	        }
	    }

	    if (index != -1) {
	        // Update the employee's information
	        employees.set(index, updatedEmployee);

	        // Save the updated list back to the file
	        List<String> stringList = new ArrayList<>();
	        for (Employee employee : employees) {
	            stringList.add(employee.getInfoToCSV());
	        }
	        ReadAndWriteFileCSV.writeListStringToCSV(EMPLOYEE_FILE, stringList, false);

	        System.out.println("Cập nhật thành công");
	    } else {
	        System.out.println("Không tìm thấy nhân viên để cập nhật");
	    }

	    return employees;
	}


	@Override
	public List<Employee> searchEmp(String title) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Employee searchEmp(int empID) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
