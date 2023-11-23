package ArrayListAndFramework;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	ProductManager productManager = new ProductManager();
    Scanner scanner = new Scanner(System.in);

    int choice;
    do {
        System.out.println("\n=== Product Management Menu ===");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Display All Products");
        System.out.println("5. Search Product by Name");
        System.out.println("6. Sort Products by Price (Ascending)");
        System.out.println("7. Sort Products by Price (Descending)");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");

        choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                // Thêm sản phẩm
                Product p = new Product();
                p.input();
                productManager.add(p);
                productManager.displayList();
                break;
            case 2:
                // Sửa thông tin sản phẩm
                System.out.print("Enter the product ID to update: ");
                int idChoice = scanner.nextInt();
                productManager.edit(idChoice);
                productManager.displayList();
                break;
            case 3:
                // Xoá sản phẩm
                System.out.print("Enter the product ID to delete: ");
                int idDel = Integer.parseInt(scanner.nextLine());
                productManager.remove(idDel);
                break;
            case 4:
                // Hiển thị danh sách sản phẩm
                productManager.displayList();
                break;
            case 5:
                // Tìm kiếm sản phẩm theo tên
                System.out.print("Enter the product name to search: ");
                String searchName = scanner.nextLine();
                System.out.println(productManager.search(searchName));
               
                break;
            case 6:
                // Sắp xếp sản phẩm theo giá tăng dần
                productManager.sortProductsByPriceAscending();
                System.out.println("\nAfter sorting by price ascending:");
                productManager.displayList();
                break;
            case 7:
                // Sắp xếp sản phẩm theo giá giảm dần
                productManager.sortProductsByPriceDescending();
                System.out.println("\nAfter sorting by price descending:");
                productManager.displayList();
                break;
            case 8:
                // Thoát chương trình
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 8.");
        }
    } while (choice != 8);
 }
}


