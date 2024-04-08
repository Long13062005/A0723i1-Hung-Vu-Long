package repo.imp;

import java.util.ArrayList;
import java.util.List;

import Util.ReadAndWriteFileCSV;
import models.Bike;
import repo.IRepository;
import repo.interface_repo.IBikeRepository;

public class BikeRepository implements IBikeRepository {
	private final String BIKE_FILE = "src/data/XeMay.csv";

	@Override
	public List<Bike> getAll() {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
        stringList= ReadAndWriteFileCSV.readFileCSV(BIKE_FILE);
        List<Bike> bikeList = new ArrayList<>();
        String[] array = null;
        for (String line: stringList) {
            array = line.split(",");
            Bike bike = new Bike(array[0],array[1], array[2], array[3],  array[4] );
            bikeList.add(bike);
        }
        return bikeList;
	}

	@Override
	public void update(List<Bike> t) {
		// TODO Auto-generated method stub
		 List<String> stringList = new ArrayList<>();
//       ReadAndWriteFileCSV.deleteDataFile(CUSTOMER_DATA);
       for (Bike bike : t) {
           stringList.add(bike.getInfoToCSV());
       }
       ReadAndWriteFileCSV.writeListStringToCSV(BIKE_FILE, stringList, false);
   }
	

	@Override
	public void add(Bike t) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
        stringList.add(t.getInfoToCSV());
        ReadAndWriteFileCSV.writeListStringToCSV(BIKE_FILE, stringList, true);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		List<Bike> bikeList = getAll();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < bikeList.size(); i++) {
            if (i != id) {
                stringList.add(bikeList.get(i).getInfoToCSV());
            }
        }
        ReadAndWriteFileCSV.writeListStringToCSV(BIKE_FILE, stringList, false);
	}

}
