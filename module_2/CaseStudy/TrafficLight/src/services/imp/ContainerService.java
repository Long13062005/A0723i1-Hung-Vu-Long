package services.imp;

import java.util.List;
import java.util.Scanner;

import models.Bike;
import models.Car;
import models.Container;
import repo.imp.CarRepository;
import repo.imp.ContainerRepository;
import repo.interface_repo.ICarRepository;
import repo.interface_repo.IContainerRepository;
import services.IService;
import services.interface_service.ICarService;
import services.interface_service.IContainerService;

import java.util.regex.Pattern;

public class ContainerService implements IContainerService {
	private final String PLATE = "(\\w{2}-\\d{3}\\.\\d{2})";
	private final String BRAND = "([^,]+)";
	private final String DATE_CREATE = "(\\d{4}),([^,]+)";
	private final String OWNER = "([^,]+)";
	private final String TRONGTAI = "(\\d+)$ ";
	
	private Scanner scanner = new Scanner(System.in);
	private IContainerRepository containerRepository = new ContainerRepository();
	 
	
	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		List<Container> containerList = containerRepository.getAll();
        for (Container c : containerList) {
            System.out.println(c);
        }
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		Boolean flag = true;
		System.out.println("Input Container's ID ");
        String vehicleId = null;
        do {
        	flag = false;
        	vehicleId = inputValueWithRegex(PLATE, "Error ! format of Container's ID is 43X-XXX.XX , X from 0 to 9 , Try again!");
        	if (checkExistContainerId(vehicleId)) {
                flag = true;
                System.out.println("Error, Id Container has exist, try again.");
            }
        } while (flag);
		System.out.println("Input Brand : ");
		String brand = inputValueWithRegex(BRAND, "Error ! format of Container's Brand must be Uppercase 1st letter of each word,Try again! ");
		System.out.println("Year create : ");
		String dateCreate = inputValueWithRegex(DATE_CREATE, "Error ! format of Container's Year Create is XXXX X from 0-9,Try again! ");
		System.out.println("Owner : ");
		String owner = inputValueWithRegex(OWNER, "Error ! format of Container's Owner like example : Nguyen Van A");
		System.out.println("Seats : " );
		String trongTai = inputValueWithRegex(TRONGTAI, "Error ! format of Container's seats is a number");
		 Container container = new Container(vehicleId,brand,dateCreate,owner,trongTai);
	        containerRepository.add(container);
	        System.out.println("-----Add New Container Successful-------");
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
	  private boolean checkExistContainerId(String id) {
	        List<Container> containerList = containerRepository.getAll();
	        for (Container c : containerList) {
	            if (c.getId().equals(id)) {
	                return true;
	            }
	        }
	        return false;
	    }

	  @Override
		public void checkID(String id) {
			// TODO Auto-generated method stub
			List<Container> containerList = containerRepository.getAll();
			for(int i = 0;i < containerList.size();i++) {
				if(containerList.get(i).getId().equals(id)) {
					 containerRepository.delete(i);
				} 
			}
			
		}
}
