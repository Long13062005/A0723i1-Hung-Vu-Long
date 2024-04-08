package Model.Facility;

public abstract class Facility {
	private String maDichVu;
	private String tenDichVu;
	private int areaUsed;
	private double rentPrice;
	private int peopleQuantity;
	private String kieuThue;
	public Facility(String maDichVu, String tenDichVu, int areaUsed, double rentPrice, int peopleQuantity,
			String kieuThue) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.areaUsed = areaUsed;
		this.rentPrice = rentPrice;
		this.peopleQuantity = peopleQuantity;
		this.kieuThue = kieuThue;
	}
	public Facility() {
		super();
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public int getAreaUsed() {
		return areaUsed;
	}
	public void setAreaUsed(int areaUsed) {
		this.areaUsed = areaUsed;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public int getPeopleQuantity() {
		return peopleQuantity;
	}
	public void setPeopleQuantity(int peopleQuantity) {
		this.peopleQuantity = peopleQuantity;
	}
	public String getKieuThue() {
		return kieuThue;
	}
	public void setKieuThue(String kieuThue) {
		this.kieuThue = kieuThue;
	}
	@Override
	public String toString() {
		return "maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", areaUsed=" + areaUsed + ", rentPrice="
				+ rentPrice + ", peopleQuantity=" + peopleQuantity + ", kieuThue=" + kieuThue ;
	}
	public String getInforToCSV() {
		// TODO Auto-generated method stub
		return this.maDichVu + " , "+ this.tenDichVu + " , "+ this.areaUsed+ " , "+ this.rentPrice+ " , "+ this.peopleQuantity+ " , "+ this.kieuThue;
	}
	
}
