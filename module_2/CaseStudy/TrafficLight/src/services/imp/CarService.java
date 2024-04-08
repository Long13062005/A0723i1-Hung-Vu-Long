package services.imp;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import models.Bike;
import models.Car;
import repo.imp.CarRepository;
import repo.interface_repo.ICarRepository;
import repo.interface_repo.IContainerRepository;
import services.interface_service.ICarService;
import services.interface_service.IContainerService;

public class CarService implements ICarService {

	private final String PLATE = "(\\w{2}-\\d{3}\\.\\d{2})";
	private final String BRAND = "([^,]+)";
	private final String DATE_CREATE = "(\\d{4}),([^,]+)";
	private final String CATEGORY = "([\\w\\s]+)";
	private final String OWNER = "([^,]+)";
	private final String SEATS = "(\\d+)$ ";
	
	private Scanner scanner = new Scanner(System.in);
	private ICarRepository carRepository = new CarRepository();
	 
	
	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		List<Car> carList = carRepository.getAll();
        for (Car c : carList) {
            System.out.println(c);
        }
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		Boolean flag = true;
		System.out.println("Input Car's ID ");
        String vehicleId = null;
        do {
        	flag = false;
        	vehicleId = inputValueWithRegex(PLATE, "Error ! format of Car's ID is 43X-XXX.XX , X from 0 to 9 , Try again!");
        	if (checkExistCarId(vehicleId)) {
                flag = true;
                System.out.println("Error, Id Car has exist, try again.");
            }
        } while (flag);
		System.out.println("Input Brand : ");
		String brand = inputValueWithRegex(BRAND, "Error ! format of Car's Brand must be Uppercase 1st letter of each word,Try again! ");
		System.out.println("Year create : ");
		String dateCreate = inputValueWithRegex(DATE_CREATE, "Error ! format of Car's Year Create is XXXX X from 0-9,Try again! ");
		System.out.println("Category : ");
		String category = inputValueWithRegex(CATEGORY, "Error ! format of Car's category must be example like : Xe Khách, Du lịch... ");
		System.out.println("Owner : ");
		String owner = inputValueWithRegex(OWNER, "Error ! format of Car's Owner like example : Nguyen Van A");
		System.out.println("Seats : ");
		String seats = inputValueWithRegex(SEATS, "Error ! format of Container's seats is a number");
		Car car = new Car(vehicleId,brand,dateCreate,category,owner,seats);
		carRepository.add(car);
        System.out.println("-----Add New Car Successful-------");

	}
	
	 private String inputValueWithRegex(String REGEX, String errorMessage) {
	        String value;
	        boolean flag;
	        do {
	            flag = false;
	            value = scanner.nextLine();
	            if (!checkRegex(REGEX, value)) {
	                System.out.println(errorMessage);
	                flag = true;
	            }
	        } while (flag);
	        return value;
	    }
	 
	  private boolean checkRegex(String regex, String string) {
	        return Pattern.matches(regex, string);
	    }
	  private boolean checkExistCarId(String id) {
	        List<Car> carList = carRepository.getAll();
	        for (Car car : carList) {
	            if (car.getId().equals(id)) {
	                return true;
	            }
	        }
	        return false;
	    }

	  @Override
		public void checkID(String id) {
			// TODO Auto-generated method stub
			List<Car> carList = carRepository.getAll();
			for(int i = 0;i < carList.size();i++) {
				if(carList.get(i).getId().equals(id)) {
					 carRepository.delete(i);
				} 
			}
			
		}

}
