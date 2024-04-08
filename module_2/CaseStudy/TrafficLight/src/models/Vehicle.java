package models;

public abstract class Vehicle {
	private String id;
	private String brand;
	private String dateCreate;
	private String owner;
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", brand=" + brand + ", dateCreate=" + dateCreate + ", owner=" + owner + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Vehicle(String id, String brand, String dateCreate, String owner) {
		super();
		this.id = id;
		this.brand = brand;
		this.dateCreate = dateCreate;
		this.owner = owner;
	}
	public Vehicle() {
		super();
	}
	
}
