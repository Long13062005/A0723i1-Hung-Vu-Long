package Repo.imp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Facility.Facility;
import Model.Facility.House;
import Model.Facility.Room;
import Model.Facility.Villa;
import Model.Person.Customer;
import Model.Person.Employee;
import Repo.Interface.IFacilityRepository;
import Util.ReadAndWriteFileCSV;

public class FacilityRepository implements IFacilityRepository {
	 private final String FACILITY_FILE ="src/Data/Facility/Facility.csv";

	@Override
	public List<Facility> getAll() {
		List<String> stringList = new ArrayList<>();
        stringList= ReadAndWriteFileCSV.readFileCSV(FACILITY_FILE);
        List<Facility> facilityList = new ArrayList<>();
        String[] array = null;
        for (String line: stringList) {
            array = line.split(",");
            if (array[0].contains("SVVL")) {
                Facility facility = new Villa(array[0], array[1], Integer.parseInt(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6], Integer.parseInt(array[7]), Integer.parseInt(array[8]));
                facilityList.add(facility);
            } else if ((array[0].contains("SVHO"))) {
                Facility facility = new House( array[0], array[1], Integer.parseInt(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6], Integer.parseInt(array[7]));
                facilityList.add(facility);
            } else
                facilityList.add(new Room(array[0], array[1], Integer.parseInt(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6]));
        }
            
        return facilityList;
	}

	@Override
	public List<Facility> update(Facility updateFacility) {
		List<Facility> facilitys = getAll();

	    // Find the index of the employee to be updated based on their ID
	    int index = -1;
	    for (int i = 0; i < facilitys.size(); i++) {
	        if (facilitys.get(i).getMaDichVu() == updateFacility.getMaDichVu()) {
	            index = i;
	            break;
	        }
	    }

	    if (index != -1) {
	        // Update the employee's information
	        facilitys.set(index, updateFacility);

	        // Save the updated list back to the file
	        List<String> stringList = new ArrayList<>();
	        for (Facility f : facilitys) {
	            stringList.add(f.getInforToCSV());
	        }
	        ReadAndWriteFileCSV.writeListStringToCSV(FACILITY_FILE, stringList, false);

	        System.out.println("Cập nhật thành công");
	    } else {
	        System.out.println("Không tìm thấy để cập nhật");
	    }

	    return facilitys;
  }


	@Override
	public void add(Facility facility) {
		// TODO Auto-generated method stub
		 List<String> stringList = new ArrayList<>();
	        stringList.add(facility.getInforToCSV());
	        ReadAndWriteFileCSV.writeListStringToCSV(FACILITY_FILE, stringList, true);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		List<Facility> f = getAll();
		List<String> stringList = new ArrayList<>() ;
		for (int i = 0;i < f.size();i++) {
			if ( f.get(i).getMaDichVu()!=id){
                stringList.add(f.get(i).getInforToCSV());
            }
		}
		ReadAndWriteFileCSV.writeListStringToCSV(FACILITY_FILE,stringList,false);
        if (f.size()!=stringList.size()){
            System.out.println("xoá thành công");
        }else {
            System.out.println("Xoá không thành công");
        }
	}

	

}
