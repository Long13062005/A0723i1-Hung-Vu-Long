package repo.imp;

import java.util.ArrayList;

import java.util.List;

import Util.ReadAndWriteFileCSV;
import models.Car;
import models.Car;
import repo.IRepository;
import repo.interface_repo.ICarRepository;

public class CarRepository implements ICarRepository {
	private final String CAR_FILE = "src/Data/Oto.csv";

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
        stringList= ReadAndWriteFileCSV.readFileCSV(CAR_FILE);
        List<Car> carList = new ArrayList<>();
        String[] array = null;
        for (String line: stringList) {
            array = line.split(",");
            Car car = new Car(array[0],array[1], array[2], array[3], array[4],array[5] );
            carList.add(car);
        }
        return carList;
	}

	@Override
	public void update(List<Car> t) {
		// TODO Auto-generated method stub
		 List<String> stringList = new ArrayList<>();
//       ReadAndWriteFileCSV.deleteDataFile(CUSTOMER_DATA);
       for (Car car : t) {
           stringList.add(car.getInfoToCSV());
       }
       ReadAndWriteFileCSV.writeListStringToCSV(CAR_FILE, stringList, false);
   }
	

	@Override
	public void add(Car t) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
        stringList.add(t.getInfoToCSV());
        ReadAndWriteFileCSV.writeListStringToCSV(CAR_FILE, stringList, true);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		List<Car> carList = getAll();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            if (i != id) {
                stringList.add(carList.get(i).getInfoToCSV());
            }
        }
        ReadAndWriteFileCSV.writeListStringToCSV(CAR_FILE, stringList, false);
	}

}
