package models;

public abstract class TypeProduct {
	private int id;
	private String code;
	private String name;
	private String price;
	private String quanitity;
	private String producer;
	
	
	public TypeProduct(int id, String code, String name, String price, String quanitity, String producer) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.quanitity = quanitity;
		this.producer = producer;
	}
	
	public TypeProduct() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuanitity() {
		return quanitity;
	}
	public void setQuanitity(String quanitity) {
		this.quanitity = quanitity;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	@Override
	public String toString() {
		return "TypeProduct [id=" + id + ", code=" + code + ", name=" + name + ", price=" + price + ", quanitity="
				+ quanitity + ", producer=" + producer + "]";
	}
	abstract String getInfoToCSV();
	
	

}
