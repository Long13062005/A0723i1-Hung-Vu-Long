package controller;

import java.util.Scanner;

import repository.interface_repo.IProductInRepository;
import service.IService;
import service.imp.ProductInService;
import service.imp.ProductOutService;
import service.interface_service.IProductInService;
import service.interface_service.IProductOutService;

public class ProductController {
		private IProductInService productInService = new ProductInService();
		private IProductOutService productOutService = new ProductOutService();
		Scanner sc = new Scanner(System.in);
		public void mainMenu() {
			int choice;
			do {
				System.out.println("\t \t --CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM--");
				System.out.println("\t Chọn chức năng theo số (để tiếp tục):");
				System.out.println("\t 1.Thêm mới");
				System.out.println("\t 2.Xóa");
				System.out.println("\t 3.Xem danh sách các sản phẩm");
				System.out.println("\t 4.Tìm kiếm");
				System.out.println("\t 5.Thoát");
				System.out.println("\t Chọn chức năng : ");
				System.out.println();
				choice = sc.nextInt();
				switch(choice) {
				case 1 :
					menuAdd();
//					System.out.println("Trieu");
					break;
				case 2 :
					menuDel();
//					System.out.println("Ngu");
					break;
				case 3 :
					menuDisplay();
					break;
				case 4 :
					menuSearch();
					break;
				case 5 :
					System.out.println("Cảm ơn bạn đã sử dụng");
					break;
				default :
					System.out.println("\t Không hợp lệ, vui lòng thử lại từ 1 - 5!!!");
				}
			} while (choice != 5);
			
		}
		public void menuAdd() {
			int choice;
			do {
				System.out.println("\t 1.Thêm sản phẩm nhập khẩu");
				System.out.println("\t 2.Thêm sản phẩm xuất khẩu");
				System.out.println("\t 3.Thoát");
				System.out.println("\t Chọn chức năng : ");

				choice = sc.nextInt();
				switch(choice) {
				case 1 :
					productInService.add();
					break;
				case 2 :
					productOutService.add();
					break;
				case 3 :
					mainMenu();
					break;
				default :
					System.out.println("\t Không hợp lệ, vui lòng thử lại từ 1 - 3!!!");
				}
			} while (choice != 3);
			
		}
		
		public void menuDel() {
			int choice;
			do {
				System.out.println("\t 1.Xóa sản phẩm nhập khẩu");
				System.out.println("\t 2.Xóa sản phẩm xuất khẩu");
				System.out.println("\t 3.Thoát");
				System.out.println("\t Chọn chức năng : ");

				choice = sc.nextInt();
				switch(choice) {
				case 1 :
					productInService.delete();
					break;
				case 2 :
					productOutService.delete();
					break;
				case 3 :
					mainMenu();
					break;
				default :
					System.out.println("\t Không hợp lệ, vui lòng thử lại từ 1 - 3!!!");
				}
			} while (choice != 3);
			
		}
		
		public void menuSearch() {
			int choice;
			do {
				System.out.println("\t 1.Tìm sản phẩm nhập khẩu theo id");
				System.out.println("\t 2.Tìm sản phẩm xuất khẩu theo id");
				System.out.println("\t 3.Tìm sản phẩm nhập khẩu theo tên");
				System.out.println("\t 4.Tìm sản phẩm xuất khẩu theo tên");
				System.out.println("\t 5.Thoát");
				System.out.println("\t Chọn chức năng : ");

				choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
				case 1 :
					System.out.println("Nhập id của sản phẩm nhập khẩu bạn muốn tìm : ");
					int id = sc.nextInt();
					productInService.search(id);
					break;
				case 2 :
					System.out.println("Nhập id của sản phẩm nhập khẩu bạn muốn tìm : ");
					int id1 = sc.nextInt();
					productOutService.search(id1);
					break;
				case 3 :
					System.out.println("Nhập ten của sản phẩm nhập khẩu bạn muốn tìm : ");
					String name1 = sc.nextLine();
					productInService.searchName(name1);
					break;
				case 4 :
					System.out.println("Nhập ten của sản phẩm xuất khẩu bạn muốn tìm : ");
					String name2 = sc.nextLine();
					productOutService.searchName(name2);
					break;
				case 5 :
					mainMenu();
					break;
				default :
					System.out.println("\t Không hợp lệ, vui lòng thử lại từ 1 - 3!!!");
				}
			} while (choice != 5);
			
		}
		public void menuDisplay() {
			int choice;
			do {
				System.out.println("\t 1.Hiển thị sản phẩm nhập khẩu");
				System.out.println("\t 2.Hiển thị sản phẩm xuất khẩu");
				System.out.println("\t 3.Thoát");
				System.out.println("\t Chọn chức năng : ");

				choice = sc.nextInt();
				switch(choice) {
				case 1 :
					productInService.displayAll();
					break;
				case 2 :
					productOutService.displayAll();
					break;
				case 3 :
					mainMenu();
					break;
				default :
					System.out.println("\t Không hợp lệ, vui lòng thử lại từ 1 - 3!!!");
				}
			} while (choice != 3);
			
		}
	}

