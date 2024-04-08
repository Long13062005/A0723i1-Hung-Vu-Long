package Repo.imp;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import Model.Booking;
import Model.Contract;
 import Repo.Interface.IContractRepository;
import Util.ReadAndWriteFileCSV;

public class ContractRepository implements IContractRepository<Contract> {
	private final String CONTRACT_FILE = "src/data/Booking.csv";
	@Override
	public List<Contract> getAll() {
		List<String> stringList = ReadAndWriteFileCSV.readFileCSV(CONTRACT_FILE);
        List<Contract> contractList = new ArrayList<>();
        String[] array;
        for (String s : stringList) {
            array = s.split(",");
            contractList.add(new Contract(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3])));
        }
        return contractList;
	}

	@Override
	public void update(List<Contract> contractList) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
//      ReadAndWriteFileCSV.deleteDataFile(BOOKING_DATA);
      for (Contract c : contractList) {
          stringList.add(c.getInforToCSV());
      }
      ReadAndWriteFileCSV.writeListStringToCSV(CONTRACT_FILE, stringList, false);
	}

	@Override
	public void add(Contract t) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
        stringList.add(t.getInforToCSV());
        ReadAndWriteFileCSV.writeListStringToCSV(CONTRACT_FILE, stringList, true);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
        List<Contract> contractList = getAll();
        for (int i = 0; i < contractList.size(); i++) {
            if (i != id) {
                stringList.add(contractList.get(i).getInforToCSV());
            }
        }
        ReadAndWriteFileCSV.writeListStringToCSV(CONTRACT_FILE, stringList, false);
	}


}
