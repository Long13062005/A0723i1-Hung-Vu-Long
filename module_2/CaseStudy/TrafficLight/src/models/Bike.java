package models;

public class Bike extends Vehicle {
	private String congSuat;

	public Bike(String id, String brand, String dateCreate, String owner, String congSuat) {
		super(id, brand, dateCreate, owner);
		this.congSuat = congSuat;
	}

	public Bike() {
		super();
	}

	public String getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(String congSuat) {
		this.congSuat = congSuat;
	}

	@Override
	public String toString() {
		return "Bike  [id=" + super.getId() + ", brand=" + super.getBrand() + ", dateCreate=" + super.getDateCreate() + ", owner=" + super.getOwner() +"Cong suat = " + congSuat + "]";
	}
	
	public String getInfoToCSV() {
		// TODO Auto-generated method stub
		return super.getId() + " , " + super.getBrand() + " , " + super.getDateCreate() + " , " +super.getOwner() + " , " + this.congSuat;
				}
}
