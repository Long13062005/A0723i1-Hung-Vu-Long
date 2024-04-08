package models;

public class ProductIn extends TypeProduct {
	private String priceIn;
	private String cityIn;
	private String taxIn;
	public ProductIn(int id, String code, String name, String price, String quanitity, String producer,
			String priceIn, String cityIn, String taxIn) {
		super(id, code, name, price, quanitity, producer);
		this.priceIn = priceIn;
		this.cityIn = cityIn;
		this.taxIn = taxIn;
	}
	public ProductIn() {
		super();
	}
	public String getPriceIn() {
		return priceIn;
	}
	public void setPriceIn(String priceIn) {
		this.priceIn = priceIn;
	}
	public String getCityIn() {
		return cityIn;
	}
	public void setCityIn(String cityIn) {
		this.cityIn = cityIn;
	}
	public String getTaxIn() {
		return taxIn;
	}
	public void setTaxIn(String taxIn) {
		this.taxIn = taxIn;
	}
	@Override
	public String toString() {
		return "ProductIn [id=" + super.getId() + ", code=" + super.getCode() + ", name=" + super.getName() + ", price=" + super.getPrice() + ", quanitity="
				+ super.getQuanitity() + ", producer=" + super.getProducer() +  "priceIn=" + priceIn + ", cityIn=" + cityIn + ", taxIn=" + taxIn + "]";
		
	}
	@Override
	public String getInfoToCSV() {
		return super.getId() + "," + super.getCode() + "," + super.getName() + "," + super.getPrice() + "," + super.getQuanitity() + "," + super.getProducer() + "," + this.priceIn + "," + this.cityIn + "," + this.taxIn;
	}
	
	

}
