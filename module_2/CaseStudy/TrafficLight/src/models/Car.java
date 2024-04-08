package models;

public class Car extends Vehicle {
	private String seats;
	private String typeCar;
	public Car(String id, String brand, String dateCreate, String owner, String seats, String typeCar) {
		super(id, brand, dateCreate, owner);
		this.seats = seats;
		this.typeCar = typeCar;
	}
	public Car() {
		super();
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getTypeCar() {
		return typeCar;
	}
	public void setTypeCar(String typeCar) {
		this.typeCar = typeCar;
	}
	@Override
	public String toString() {
		return "Car  [id=" + super.getId() + ", brand=" + super.getBrand() + ", dateCreate=" + super.getDateCreate() + ", owner=" + super.getOwner() +"seats=" + seats + ", typeCar=" + typeCar + "]";
		 
	}
	
	public String getInfoToCSV() {
		// TODO Auto-generated method stub
		return super.getId() + " , " + super.getBrand() + " , " + super.getDateCreate() + " , " +super.getOwner() + " , " + this.seats+ " , " + this.typeCar;
				}
}
