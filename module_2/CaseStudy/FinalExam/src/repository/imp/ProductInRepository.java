package repository.imp;

import java.util.ArrayList;
import java.util.List;

import models.ProductIn;
import repository.interface_repo.IProductInRepository;
import util.ReadAndWriteFileCSV;

public class ProductInRepository implements IProductInRepository  {
	private final String PRODUCTIN_FILE = "src/data/ProductIn.csv";
	@Override
	public List<ProductIn> getAll() {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
		stringList = ReadAndWriteFileCSV.readFileCSV(PRODUCTIN_FILE);
		List<ProductIn> inList = new ArrayList<>();
		String[] array = null;
		for(String line : stringList) {
			array = line.split(",");
			ProductIn productIn = new ProductIn(Integer.parseInt(array[0]),array[1],array[2],array[3],array[4],array[5],array[6],array[7],array[8]);
			inList.add(productIn);
		}
		return inList;
	}

	@Override
	public void update(List<ProductIn> t) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
		for(ProductIn p : t) {
			stringList.add(p.getInfoToCSV());
		}
		ReadAndWriteFileCSV.writeListStringToCSV(PRODUCTIN_FILE, stringList, false);
		
	}

	@Override
	public void add(ProductIn t) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
		stringList.add(t.getInfoToCSV());
		ReadAndWriteFileCSV.writeListStringToCSV(PRODUCTIN_FILE, stringList, false);
	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		List<ProductIn> inList = getAll();
		List<String> stringList = new ArrayList<>();
		for(int i = 0; i < inList.size();i++) {
			if(i != index)
				stringList.add(inList.get(i).getInfoToCSV());
		}
		ReadAndWriteFileCSV.writeListStringToCSV(PRODUCTIN_FILE, stringList, false);
	}
	
}
