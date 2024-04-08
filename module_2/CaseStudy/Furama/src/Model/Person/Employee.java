package Model.Person;

import java.time.LocalDate;
import java.util.Scanner;

enum EducationLevel {
    HIGH_SCHOOL, COLLEGE, UNIVERSITY, POST_GRADUATE
}

// Enum để định nghĩa các vị trí
enum Position {
    RECEPTIONIST, WAITER, SPECIALIST, SUPERVISOR, MANAGER, DIRECTOR
}

public class Employee extends Person{
	
    private String trinhDo;
    private String viTri;
    private double luong;
	public Employee(String maNhanVien, String hoTen, String ngaySinh, String gioiTinh, String soCMND,
			String soDienThoai, String email, String trinhDo, String viTri, double luong) {
		super(maNhanVien, hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email);
		this.trinhDo = trinhDo;
		this.viTri = viTri;
		this.luong = luong;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee ["+ super.toString()+"trinhDo=" + trinhDo + ", viTri=" + viTri + ", luong=" + luong + "]";
	}
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
//   public void input() {
//	   super.input();
//	   try (Scanner sc = new Scanner(System.in)) {
//		System.out.print("Trinh do : ");
//		   this.trinhDo = sc.nextLine();
//		   System.out.print("Vi tri : ");
//		   this.viTri = sc.nextLine();
//		   System.out.print("Luong : ");
//		   this.luong = Double.parseDouble(sc.nextLine());
//	} catch (NumberFormatException e) {
//		// TODO Auto-generated catch block
//		System.out.println("Luong khong nhan dang");
//	}
	public  String getInfoToCSV() {
		// TODO Auto-generated method stub
		
		return  super.getMaNhanVien()  + " , " + super.getHoTen()  + " , " + super.getNgaySinh()  + " , " + super.getGioiTinh()  + " , " +  super.getSoCMND()  + " , " + super.getSoDienThoai()  + " , " + super.getEmail()  + " , "  + this.trinhDo + " , " + this.viTri + " , "  + this.luong;
	}
	

       
//   }
	
    
}
