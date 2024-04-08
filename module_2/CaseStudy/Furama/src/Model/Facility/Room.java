package Model.Facility;

public class Room extends Facility {
	
	private String bonusService;

	public Room(String maDichVu, String tenDichVu, int areaUsed, double rentPrice, int peopleQuantity, String kieuThue,
			String bonusService) {
		super(maDichVu, tenDichVu, areaUsed, rentPrice, peopleQuantity, kieuThue);
		this.bonusService = bonusService;
	}

	public Room() {
		super();
	}

	public String getBonusService() {
		return bonusService;
	}

	public void setBonusService(String bonusService) {
		this.bonusService = bonusService;
	}

	@Override
	public String toString() {
		return "Room = [" + super.toString() + "bonusService=" + bonusService + "]";
	}
	
	
	
}
