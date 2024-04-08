package repo.imp;

import java.util.ArrayList;
import java.util.List;

import Util.ReadAndWriteFileCSV;
import models.Container;
import repo.IRepository;
import repo.interface_repo.IContainerRepository;

public class ContainerRepository implements IContainerRepository {
	private final String CONTAINER_FILE = "src/Data/XeTai.csv";
	@Override
	public List<Container> getAll() {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
        stringList= ReadAndWriteFileCSV.readFileCSV(CONTAINER_FILE);
        List<Container> containerList = new ArrayList<>();
        String[] array = null;
        for (String line: stringList) {
            array = line.split(",");
            Container bike = new Container(array[0],array[1], array[2], array[3], array[4] );
            containerList.add(bike);
        }
        return containerList;
	}

	@Override
	public void update(List<Container> t) {
		// TODO Auto-generated method stub
		 List<String> stringList = new ArrayList<>();
//       ReadAndWriteFileCSV.deleteDataFile(CUSTOMER_DATA);
       for (Container container : t) {
           stringList.add(container.getInfoToCSV());
       }
       ReadAndWriteFileCSV.writeListStringToCSV(CONTAINER_FILE, stringList, false);
   }
	

	@Override
	public void add(Container t) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
        stringList.add(t.getInfoToCSV());
        ReadAndWriteFileCSV.writeListStringToCSV(CONTAINER_FILE, stringList, true);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		List<Container> containerList = getAll();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < containerList.size(); i++) {
            if (i != id) {
                stringList.add(containerList.get(i).getInfoToCSV());
            }
        }
        ReadAndWriteFileCSV.writeListStringToCSV(CONTAINER_FILE, stringList, false);
	}

}
