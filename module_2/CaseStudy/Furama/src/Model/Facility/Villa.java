package Model.Facility;

public class Villa extends Facility {
	
	private String tieuChuan;
	private int poolArea;
	private int floor;
	public Villa(String maDichVu, String tenDichVu, int areaUsed, double rentPrice, int peopleQuantity, String kieuThue,
			String tieuChuan, int poolArea, int floor) {
		super(maDichVu, tenDichVu, areaUsed, rentPrice, peopleQuantity, kieuThue);
		this.tieuChuan = tieuChuan;
		this.poolArea = poolArea;
		this.floor = floor;
	}
	public Villa() {
		super();
	}
	public String getTieuChuan() {
		return tieuChuan;
	}
	public void setTieuChuan(String tieuChuan) {
		this.tieuChuan = tieuChuan;
	}
	public int getPoolArea() {
		return poolArea;
	}
	public void setPoolArea(int poolArea) {
		this.poolArea = poolArea;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	@Override
	public String toString() {
		return "Villa = [" +  super.toString() +" tieuChuan=" + tieuChuan + ", poolArea=" + poolArea + ", floor=" + floor + "]";
	}
	
	
	
}
