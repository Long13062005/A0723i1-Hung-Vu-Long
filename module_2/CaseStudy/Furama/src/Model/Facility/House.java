package Model.Facility;

public class House extends Facility {
	
	private String tieuChuan;
	private int floor;
	
	public String getTieuChuan() {
		return tieuChuan;
	}
	public void setTieuChuan(String tieuChuan) {
		this.tieuChuan = tieuChuan;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public House(String maDichVu, String tenDichVu, int areaUsed, double rentPrice, int peopleQuantity, String kieuThue,
			String tieuChuan, int floor) {
		super(maDichVu, tenDichVu, areaUsed, rentPrice, peopleQuantity, kieuThue);
		this.tieuChuan = tieuChuan;
		this.floor = floor;
	}
	
	public House() {
		super();
	}
	@Override
	public String toString() {
		return "House = [" + super.toString() + "tieuChuan=" + tieuChuan + ", floor=" + floor + "]";
	}
	
	
	
}
