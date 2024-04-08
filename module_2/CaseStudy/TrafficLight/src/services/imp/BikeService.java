package services.imp;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import models.Bike;
import models.Car;
import repo.imp.BikeRepository;
import repo.imp.CarRepository;
import repo.interface_repo.ICarRepository;
import services.interface_service.IBikeService;
import repo.interface_repo.IBikeRepository;


public class BikeService implements IBikeService {
	private final String PLATE = "(\\w{2}-\\w{2}-\\d{3}\\.\\d{2})";
	private final String BRAND = "([^,]+)";
	private final String DATE_CREATE = "(\\d{4}),([^,]+)";
	private final String OWNER = "([^,]+)";
	private final String CONGSUAT = "(\\d+)$ ";
	
	private Scanner scanner = new Scanner(System.in);
	private IBikeRepository bikeRepository = new BikeRepository();
	 
	
	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		List<Bike> bikeList = bikeRepository.getAll();
        for (Bike b : bikeList) {
            System.out.println(b);
        }
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		Boolean flag = true;
		System.out.println("Input Bike's ID ");
        String vehicleId = null;
        do {
        	flag = false;
        	vehicleId = inputValueWithRegex(PLATE, "Error ! format of Bike's ID is 43X-XXX.XX , X from 0 to 9 , Try again!");
        	if (checkExistBikeId(vehicleId)) {
                flag = true;
                System.out.println("Error, Id Bike has exist, try again.");
            }
        } while (flag);
		System.out.println("Input Brand : ");
		String brand = inputValueWithRegex(BRAND, "Error ! format of Car's Brand must be Uppercase 1st letter of each word,Try again! ");
		System.out.println("Year create : ");
		String dateCreate = inputValueWithRegex(DATE_CREATE, "Error ! format of Car's Year Create is XXXX X from 0-9,Try again! ");
		
		System.out.println("Owner : ");
		String owner = inputValueWithRegex(OWNER, "Error ! format of Car's Owner like example : Nguyen Van A");
		System.out.println("Cong suat : ");
		String congSuat = inputValueWithRegex(CONGSUAT, "Error ! format of Container's seats is a number");
		Bike bike = new Bike(vehicleId,brand,dateCreate,owner,congSuat);
		bikeRepository.add(bike);
        System.out.println("-----Add New Bike Successful-------");

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
	  private boolean checkExistBikeId(String id) {
	        List<Bike> bikeList = bikeRepository.getAll();
	        for (Bike b : bikeList) {
	            if (b.getId().equals(id)) {
	                return true;
	            }
	        }
	        return false;
	    }

	@Override
	public void checkID(String id) {
		// TODO Auto-generated method stub
		List<Bike> bikeList = bikeRepository.getAll();
		for(int i = 0;i < bikeList.size();i++) {
			if(bikeList.get(i).getId().equals(id)) {
				 bikeRepository.delete(i);
			} 
		}
		
	}

}
