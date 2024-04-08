package view;

import java.util.Scanner;

import controller.BikeContronller;
import models.Bike;

public class Menu {
	
	private BikeContronller bike = new BikeContronller();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		do {
			System.out.println("\t \t CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG  ");
			System.out.println("\t Chọn chức năng");
			System.out.println("\t 1. Thêm phương tiện.");
			System.out.println("\t 2. Hiển thị phương tiện.");
			System.out.println("\t 3. Xóa phương tiện.");
			System.out.println("\t 4. Thoát");
			choice = sc.nextInt();
			switch (choice) {
			case 1 : 
				menuAdd();
				break;
			case 2:
				menuDisplay();
				break;
			case 3:
				menuDel();
				break;
			case 4:
				System.out.println("\t Bạn đã thoát khỏi chương trình.");
				break;
			default:
				System.out.println("Không hợp lệ, vui lòng điền lại");
			}
		} while (choice != 4);
		
	}
	public static void menuAdd() {
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		do {
			System.out.println("\t \t THÊM MỚI PHƯƠNG TIỆN");
			System.out.println("\t Chọn chức năng");
			System.out.println("\t 1. Thêm Xe tải.");
			System.out.println("\t 2. Thêm ô tô.");
			System.out.println("\t 3. Thêm xe máy.");
			System.out.println("\t 4. Thoát");
			choice = sc.nextInt();
			switch (choice) {
			case 1 : 
				break;
			case 2:
				break;
			case 3:
				Bike newBike = new Bike();
				
				break;
			case 4:
				break;
			default:
				System.out.println("Không hợp lệ, vui lòng điền lại");
			}
		} while (choice != 4);
	}
	public static void menuDisplay() {
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		do {
			System.out.println("\t \t HIỂN THỊ PHƯƠNG TIỆN");
			System.out.println("\t Chọn chức năng");
			System.out.println("\t 1. Hiển thị Xe tải.");
			System.out.println("\t 2. Hiển thị ô tô.");
			System.out.println("\t 3. Hiển thị xe máy.");
			System.out.println("\t 4. Thoát");
			choice = sc.nextInt();
			switch (choice) {
			case 1 : 
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("Không hợp lệ, vui lòng điền lại");
			}
		} while (choice != 4);
	}
	public static void menuDel() {
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		do {
			System.out.println("\t \t XÓA PHƯƠNG TIỆN");
			System.out.println("\t Chọn chức năng");
			System.out.println("\t 1. Xóa Xe tải.");
			System.out.println("\t 2. Xóa ô tô.");
			System.out.println("\t 3. Xóa xe máy.");
			System.out.println("\t 4. Thoát");
			choice = sc.nextInt();
			switch (choice) {
			case 1 : 
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("Không hợp lệ, vui lòng điền lại");
			}
		} while (choice != 4);
	}
}
