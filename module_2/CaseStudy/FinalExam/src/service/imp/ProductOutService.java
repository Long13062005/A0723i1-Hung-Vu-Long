package service.imp;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import models.ProductOut;
import service.interface_service.IProductOutService;
import repository.imp.ProductOutRepository;
import repository.interface_repo.*;


public class ProductOutService implements IProductOutService {

	private final String MASANPHAM = "(\\w{2}\\d{5})";
	private final String TENSANPHAM = "([^,]+)";
	private final String PRICE = "(\\d+)$";
	private final String QUANITIY = "(\\d+)$";
	private final String PRODUCER = "([^,]+)";
	private final String PRICEOUT = "(\\d+)$";
	private final String COUNTRYOUT =  "([^,]+)";
	
	private Scanner sc = new Scanner(System.in);
	private IProductOutRepository productRepo = new ProductOutRepository();
	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		List<ProductOut> outList = productRepo.getAll();
		for(ProductOut p : outList)
			System.out.println(p);
	}
	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Input ProductOut's ID : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Input Code Product : ");
		String code = inputValueWithRegex(MASANPHAM, "ERROR ! format of ProductOut's code is XX-VVVVV, X is a char and V is a number ");
		System.out.println("Input Name : ");
		String name = inputValueWithRegex(TENSANPHAM, "ERROR ! format of ProductOut's name is like : Adidas,nike or random...");
		System.out.println("Input Price : ");
		String price = inputValueWithRegex(PRICE, "ERROR ! format of ProductOut's price is number example like : 10000,20000,...");
		System.out.println("Input Quanitiy : ");
		String quanitity = inputValueWithRegex(QUANITIY, "ERROR ! format of ProductOut's quanitity is number example like : 10,20,...");
		System.out.println("Input Producer : ");
		String producer = inputValueWithRegex(PRODUCER, "ERROR ! format of ProductOut's producer is a name or a random person");
		System.out.println("Input PriceOut : ");
		String priceOut = inputValueWithRegex(PRICEOUT, "ERROR ! format of ProductOut's price in is number example like : 10000,20000,...");
		System.out.println("Input CountryOut : ");
		String countryOut = inputValueWithRegex(COUNTRYOUT, "ERROR ! format of ProductOut's city in is a name of city example : Da nang ");
		
		ProductOut productOut = new ProductOut(id,code,name,price,quanitity,producer,priceOut,countryOut);
		productRepo.add(productOut);
		System.out.println("----Add New ProductOut Successful----");
	
	}
	@Override
	public void search(int id) {
		// TODO Auto-generated method stub
		List<ProductOut> outList = productRepo.getAll();
		for(ProductOut p : outList ) {
			if(p.getId() == id) {
				System.out.println(p);
			}
		}
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		List<ProductOut> product = productRepo.getAll();
		System.out.println("Nhập id bạn muốn xóa của xuất khẩu : ");
		int id = sc.nextInt();
		for(int i = 0;i<product.size();i++) {
			if (product.get(i).getId() == id) {
				productRepo.delete(i);
			}
		}
		
	}
	 private boolean checkRegex(String regex, String string) {
	        return Pattern.matches(regex, string);
	    }
	  private boolean checkExistProductId(int id) {
	        List<ProductOut> outList = productRepo.getAll();
	        for (ProductOut p : outList) {
	            if (p.getId() == id) {
	                return true;
	            }
	        }
	        return false;
	    }
		 private String inputValueWithRegex(String REGEX, String errorMessage) {
		        String value;
		        boolean flag;
		        do {
		            flag = false;
		            value = sc.nextLine();
		            if (!checkRegex(REGEX, value)) {
		                System.out.println(errorMessage);
		                flag = true;
		            }
		        } while (flag);
		        return value;
		    }
		@Override
		public void searchName(String name) {
			// TODO Auto-generated method stub
			List<ProductOut> outList = productRepo.getAll();
			for(ProductOut p : outList ) {
				if(p.getName().contains(name)) {
					System.out.println(p);
				}
			}
		}

}
