package service.imp;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import models.ProductIn;
import models.ProductOut;
import repository.imp.ProductInRepository;
import repository.interface_repo.IProductInRepository;
import service.interface_service.IProductInService;

public class ProductInService implements IProductInService{
	private final String MASANPHAM = "(\\w{2}\\d{5})";
	private final String TENSANPHAM = "([^,]+)";
	private final String PRICE = "(\\d+)$";
	private final String QUANITIY = "(\\d+)$";
	private final String PRODUCER = "([^,]+)";
	private final String PRICEIN = "(\\d+)$";
	private final String CITYIN =  "([^,]+)";
	private final String TAX = "(\\d+)$";
	
	private Scanner sc = new Scanner(System.in);
	private IProductInRepository productRepo = new ProductInRepository();
	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		List<ProductIn> inList = productRepo.getAll();
		for(ProductIn p : inList)
			System.out.println(p);
	}
	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Input ProductIn's ID : ");
		int id = sc.nextInt();
		System.out.println("Input Code Product : ");
		String code = inputValueWithRegex(MASANPHAM, "ERROR ! format of ProductIn's code is XXVVVVV, X is a char and V is a number ");
		System.out.println("Input Name : ");
		String name = inputValueWithRegex(TENSANPHAM, "ERROR ! format of ProductIn's name is like : Adidas,nike or random...");
		System.out.println("Input Price : ");
		String price = inputValueWithRegex(PRICE, "ERROR ! format of ProductIn's price is number example like : 10000,20000,...");
		System.out.println("Input Quanitiy : ");
		String quanitity = inputValueWithRegex(QUANITIY, "ERROR ! format of ProductIn's quanitity is number example like : 10,20,...");
		System.out.println("Input Producer : ");
		String producer = inputValueWithRegex(PRODUCER, "ERROR ! format of ProductIn's producer is a name or a random person");
		System.out.println("Input PriceIn : ");
		String priceIn = inputValueWithRegex(PRICEIN, "ERROR ! format of ProductIn's price in is number example like : 10000,20000,...");
		System.out.println("Input cityIn : ");
		String cityIn = inputValueWithRegex(CITYIN, "ERROR ! format of ProductIn's city in is a name of city example : Da nang ");
		System.out.println("Input tax : ");
		String tax = inputValueWithRegex(TAX, "ERROR ! format of ProductIn's price in is number example like : 10000,20000,...");
		ProductIn productIn = new ProductIn(id,code,name,price,quanitity,producer,priceIn,cityIn,tax);
		productRepo.add(productIn);
		System.out.println("----Add New ProductIn Successful----");
	
	}
	@Override
	public void search(int id) {
		// TODO Auto-generated method stub
		List<ProductIn> inList = productRepo.getAll();
		for(ProductIn p : inList ) {
			if(p.getId() == id) {
				System.out.println(p);
			}
		}
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		List<ProductIn> product = productRepo.getAll();
		System.out.println("Nhập id bạn muốn xóa của Nhập khẩu : ");
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
	        List<ProductIn> inList = productRepo.getAll();
	        for (ProductIn p : inList) {
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
			List<ProductIn> inList = productRepo.getAll();
			for(ProductIn p : inList ) {
				if(p.getName().contains(name)) {
					System.out.println(p);
				}
			}
		}
}
