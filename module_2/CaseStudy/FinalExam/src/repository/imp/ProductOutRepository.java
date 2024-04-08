package repository.imp;

import java.util.ArrayList;
import java.util.List;

import models.ProductOut;
import repository.interface_repo.IProductOutRepository;
import util.ReadAndWriteFileCSV;

public class ProductOutRepository implements IProductOutRepository {
	private final String PRODUCTOUT_FILE = "src/data/ProductOut.csv";

	@Override
	public List<ProductOut> getAll() {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
		stringList = ReadAndWriteFileCSV.readFileCSV(PRODUCTOUT_FILE);
		List<ProductOut> outList = new ArrayList<>();
		String[] arr = null;
		for(String s : stringList) {
			arr = s.split(",");
			ProductOut productOut = new ProductOut(Integer.parseInt( arr[0]),arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]);
			outList.add(productOut);
			
			}
		return outList;
	}

	@Override
	public void update(List<ProductOut> t) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
		for(ProductOut p : t) 
			stringList.add(p.getInfoToCSV());
		ReadAndWriteFileCSV.writeListStringToCSV(PRODUCTOUT_FILE, stringList, false);
	}
	

	@Override
	public void add(ProductOut t) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
		stringList.add(t.getInfoToCSV());
		ReadAndWriteFileCSV.writeListStringToCSV(PRODUCTOUT_FILE, stringList, false);
	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		List<ProductOut> outList = getAll();
		List<String> stringList = new ArrayList<>();
		for(int i = 0;i < outList.size();i++) {
			if (i != index)
				stringList.add(outList.get(i).getInfoToCSV());
		}
		ReadAndWriteFileCSV.writeListStringToCSV(PRODUCTOUT_FILE, stringList, false);
	}

}
