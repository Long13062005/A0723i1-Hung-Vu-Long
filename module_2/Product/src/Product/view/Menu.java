package Product.view;
import java.util.Scanner;

import Product.controller.ProductController;
import Product.model.Product;
public class Menu {


	

	

	public class View {
	    private static Scanner scanner = new Scanner(System.in);
	    private static final int DISPLAY =1;
	    private static  final  int ADD =2;
	    private static  final  int EDIT =3;

	    public static void main(String[] args) {
	        ProductController Product = new ProductController();
	        Scanner scanner = new Scanner(System.in);
	        boolean flag = true;
	        do {
	            System.out.println("Chọn chức năng:\n" +
	                    "1.Hiển thị danh sách\n" +
	                    "2.Thêm mới\n" +
	                    "3.Chỉnh sửa\n" +
	                    "4.Thoát");
	            int choose = Integer.parseInt(scanner.nextLine());
	            switch (choose){
	                case DISPLAY:
	                    Product[] Products = Product.getAll();
	                    displayProductList(Products);
	                    break;
	                case ADD:
	                    Product Products1 = inputDataProduct();
	                    Product.add(Products1);
	                    System.out.println("Thêm mới thành công");
	                    break;
	                case EDIT:
	                    System.out.println("Chức năng chỉnh sửa");
	                    break;
	                default:
	                    flag = false;
	            }

	        }while (flag);
	    }

	    public  static void displayProductList(Product[] products){
	        for (Product p : products) {
	            if (p !=null){
	                System.out.println(p);
	            } else {
	                break;
	            }

	        }
	    }
	    
	    public static Product inputDataProduct(){
	        System.out.print("Nhập id : ");
	        int id = Integer.parseInt(scanner.nextLine());
	        System.out.print("Nhập tên : ");
	        String name = scanner.nextLine();
	        System.out.print("Nhập giá thành tiền : ");
	        double price = scanner.nextDouble();
	        System.out.print("Nhập mô tả : ");
	        String description = scanner.nextLine();
	        Product Product = new Product(id,name,description,price);
	        return Product;
	    }
	}

}
