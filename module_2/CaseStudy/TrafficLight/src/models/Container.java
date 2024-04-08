package models;

public class Container extends Vehicle {
	private String trongTai;

	public Container(String id, String brand, String dateCreate, String owner, String trongTai) {
		super(id, brand, dateCreate, owner);
		this.trongTai = trongTai;
	}

	public Container() {
		super();
	}

	public String getTrongTai() {
		return trongTai;
	}

	public void setTrongTai(String trongTai) {
		this.trongTai = trongTai;
	}

	@Override
	public String toString() {
		return "Container  [id=" + super.getId() + ", brand=" + super.getBrand() + ", dateCreate=" + super.getDateCreate() + ", owner=" + super.getOwner() +"Trong tai = " + trongTai + "]";
	}
	public String getInfoToCSV() {
		// TODO Auto-generated method stub
		return super.getId() + " , " + super.getBrand() + " , " + super.getDateCreate() + " , " +super.getOwner() + " , " + this.trongTai;
				}
	
}
