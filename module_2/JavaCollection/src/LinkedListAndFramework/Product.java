package LinkedListAndFramework;

import java.util.Scanner;

public class Product  {
	Scanner sc = new Scanner(System.in);
	 private int productId;
	    private String name;
	    private double price;
	    private int quantity;

	    public Product(int productId, String name, double price, int quantity) {
	        this.productId = productId;
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	    }
	    

	    public Product() {
			super();
		}


		public void displayInfo() {
	        System.out.println("Product ID: " + productId);
	        System.out.println("Name: " + name);
	        System.out.println("Price: $" + price);
	        System.out.println("Quantity: " + quantity);
	        System.out.println();
	    }

	    public double calculateTotal() {
	        return price * quantity;
	    }

	    public int getProductId() {
	        return productId;
	    }

	    public void setProductId(int productId) {
	        this.productId = productId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

		@Override
		public String toString() {
			return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
					+ "]";
		}
		
		public void input() {
			System.out.print("ID : ");
			this.productId = Integer.parseInt(sc.nextLine());
			System.out.print("Name : ");
			this.name = sc.nextLine();
			System.out.print("Price : ");
			this.price = Double.parseDouble(sc.nextLine());
			System.out.print("Quantity : ");
			this.quantity = Integer.parseInt(sc.nextLine());
		}
		
	     
}
