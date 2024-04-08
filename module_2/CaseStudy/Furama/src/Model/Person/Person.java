package Model.Person;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {
	private String maNhanVien;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String soCMND;
    private String soDienThoai;
    private String email;
	public Person(String maNhanVien, String hoTen, String ngaySinh, String gioiTinh, String soCMND, String soDienThoai,
			String email) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soCMND = soCMND;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh="
				+ gioiTinh + ", soCMND=" + soCMND + ", soDienThoai=" + soDienThoai + ", email=" + email ;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	 public void input() {
//		 try (Scanner sc = new Scanner(System.in)) {
//			System.out.print("Ma Nhan Vien : ");
//	        this.maNhanVien = Integer.parseInt(sc.nextLine());
//	        System.out.print("Ho ten : ");
//	        this.hoTen = sc.nextLine();
//	        System.out.print("Ngay sinh : ");
//	        // Sử dụng next() để đọc chuỗi, sau đó chuyển thành LocalDate
//	        this.ngaySinh = LocalDate.parse(sc.next());
//	        sc.nextLine(); // Đọc và loại bỏ ký tự newline
//	        System.out.print("Gioi tinh : ");
//	        this.gioiTinh = sc.nextLine();
//	        System.out.print("So CMND : ");
//	        this.soCMND = sc.nextLine();
//	        System.out.print("SDT : ");
//	        this.soDienThoai = sc.nextLine();
//	        System.out.print("Email : ");
//	        this.email = sc.nextLine();
//		}	
//		 }
}
