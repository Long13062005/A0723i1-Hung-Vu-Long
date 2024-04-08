package Model.Person;

import java.time.LocalDate;
import java.util.Scanner;

enum typeCus{
	DIAMOND,PLATINUM,GOLD,SILVER,MEMBER;
}

public class Customer extends Person {
	private String typeCus;
	private String address;
	public Customer(String maNhanVien, String hoTen, String ngaySinh, String gioiTinh, String soCMND,
			String soDienThoai, String email, String typeCus, String address) {
		super(maNhanVien, hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email);
		this.typeCus = typeCus;
		this.address = address;
	}
	public Customer() {
		super();
	}
	public String getTypeCus() {
		return typeCus;
	}
	public void setTypeCus(String typeCus) {
		this.typeCus = typeCus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [" + super.toString() + "typeCus=" + typeCus + ", address=" + address + "]";
	}
	public String getInfoToCSV() {
		// TODO Auto-generated method stub
		return super.getMaNhanVien()  + " , " + super.getHoTen()  + " , " + super.getNgaySinh()  + " , " + super.getGioiTinh()  + " , " +  super.getSoCMND()  + " , " + super.getSoDienThoai()  + " , " + super.getEmail()  + " , "  + this.address + " , " + this.typeCus ;
	}

//	   public void input() {
//		   super.input();
//		   try (Scanner sc = new Scanner(System.in)) {
//			System.out.print("Trinh do : ");
//			   this.typeCus = sc.nextLine();
//			   System.out.print("Vi tri : ");
//			   this.address = sc.nextLine();
//		}
//	      
//	       
//	   }
}
