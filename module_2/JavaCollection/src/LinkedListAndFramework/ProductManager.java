package LinkedListAndFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
	Scanner sc = new Scanner(System.in);
	List<Product> products = new ArrayList<Product>();
	public void add(Product p) {
		products.add(p);
	}
	public void edit(int id) {
		for (Product pr : products) {
			if(pr.getProductId() == id) {
				System.out.print("New Name : ");
				String newName = sc.nextLine();
				System.out.print("New Price : ");
				double newPrice = Double.parseDouble(sc.nextLine());
				System.out.print("New Quantity : ");
				int newQuantity = Integer.parseInt(sc.nextLine());
				Product p = new Product(id, newName, newPrice, newQuantity);
				pr.setName(p.getName());
				pr.setPrice(p.getPrice());
				pr.setQuantity(p.getQuantity());
				System.out.println("--------Update--------");
				pr.displayInfo();
			}
		}
	}
	public void remove(int id) {
	        for (int i=0;i< products.size();i++) {
	            if (products.get(i).getProductId() == id) {
	                products.remove(i);
	                System.out.println("Xoá thành công");
	                return;
	            } else {
	            	System.out.println("ID khong ton tai");
	            }
	        }
	}
	public void displayList() {
		for (Product product : products) {
			product.displayInfo();
		}
	}
	public Product search(String name) {
		for (Product product : products) {
			if(product.getName().equalsIgnoreCase(name)) {
					return product;
			}
		}
		return null;
	}
	 public void sortProductsByPriceAscending() {
	        Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
	    }
	 public void sortProductsByPriceDescending() {
	        Collections.sort(products, Comparator.comparingDouble(Product::getPrice).reversed());
	    }
}
