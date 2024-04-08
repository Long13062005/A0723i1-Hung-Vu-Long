package Service.imp;

import java.util.List;
import java.util.Scanner;
import Repo.imp.*;
import java.util.Set;
import java.util.regex.Pattern;

import Model.Booking;
import Model.Facility.Facility;
import Model.Person.Customer;
import Repo.Interface.IBookingRepository;
import Service.Interface.IBookingService;

public class BookingService implements IBookingService {
	private final String DATE_REGEX = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
	Scanner scanner = new Scanner(System.in);
	  private IBookingRepository bookingRepository = new BookingRepository();
	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		Set<Booking> listBook = bookingRepository.getAll();
		for(Booking b : listBook) {
			System.out.println(b);
		}
	}
	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Input ID Booking");
	    String idBooking = scanner.nextLine();
	    System.out.println("Choose ID customer");
	    String idCustomer = inputIdCustomer();
	    System.out.println("Choose ID service");
	    String idService = inputIdService();
	    System.out.println("Input Date Start");
	    String dateStart = inputValueWithRegex(DATE_REGEX, "Invalid data, right format is yyyy-mm-dd");
	    System.out.println("Input Date End");
	    String dateEnd = inputValueWithRegex(DATE_REGEX, "Invalid data, right format is yyyy-mm-dd");
	    Booking booking = new Booking(idBooking, idService, idCustomer, dateStart, dateEnd);
	    bookingRepository.add(booking);
	    System.out.println("--------Add New Booking Successful-------");
		
	}
	@Override
	public void editByID() {
		// TODO Auto-generated method stub
		
	}
	 private String inputValueWithRegex(String REGEX, String errorMessage) {
		    String value;
		    boolean flag;
		    do {
		      flag = false;
		      value = scanner.nextLine();
		      if (!Pattern.matches(REGEX, value)) {
		        System.out.println(errorMessage);
		        flag = true;
		      }
		    } while (flag);
		    return value;
		  }
	 private String inputIdService() {
		    FacilityRepository facilityRepository = new FacilityRepository();
		    List<Facility> facilityList = facilityRepository.getAll();
		    System.out.println("List Id Service");
		    for (Facility facility : facilityList) {
		      System.out.println(facility.getTenDichVu());
		    }
		    System.out.println("Input number to choose Id Facility to booking");
		    int index;
		    boolean flag;
		    String value = null;
		    do {
		      flag = false;
		      try {
		        index = Integer.parseInt(scanner.nextLine());
		        value = facilityList.get(index).getTenDichVu();
		      } catch (Exception e) {
		        System.out.println("Invalid Number, try again");
		      }

		    } while (flag);
		    System.out.println("Add Id Services: " + value + " Successful");
		    return value;
		  }
	 private String inputIdCustomer() {
		    CustomerRepository customerRepository = new CustomerRepository();
		    List<Customer> customerList = customerRepository.getAll();
		    System.out.println("List Id Customer");
		    int i = 0;
		    for (Customer customer : customerList) {
		      System.out.println((i + 1) + ": " + customer.getMaNhanVien() + " -" + customer.getHoTen());
		      i++;
		    }
		    System.out.println("Input number to choose Id customer");
		    int index;
		    boolean flag;
		    String value = null;
		    do {
		      flag = false;
		      try {
		        index = Integer.parseInt(scanner.nextLine());
		        value = customerList.get(index - 1).getMaNhanVien();
		      } catch (Exception e) {
		        System.out.println("Invalid Number, try again");
		        flag = true;
		      }

		    } while (flag);
		    System.out.println("Add Id Customer: " + value + " Successful");
		    return value;
		  }
}
