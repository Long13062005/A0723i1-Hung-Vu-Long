package models;

public class ProductOut extends TypeProduct {
	private String priceOut;
	private String countryOut;
	public ProductOut(int id, String code, String name, String price, String quanitity, String producer,
			String priceOut, String countryOut) {
		super(id, code, name, price, quanitity, producer);
		this.priceOut = priceOut;
		this.countryOut = countryOut;
	}
	public ProductOut() {
		super();
	}
	public String getPriceOut() {
		return priceOut;
	}
	public void setPriceOut(String priceOut) {
		this.priceOut = priceOut;
	}
	public String getCountryOut() {
		return countryOut;
	}
	public void setCountryOut(String countryOut) {
		this.countryOut = countryOut;
	}
	@Override
	public String toString() {
		return "ProductOut [id=" + super.getId() + ", code=" + super.getCode() + ", name=" + super.getName() + ", price=" + super.getPrice() + ", quanitity="
				+ super.getQuanitity() + ", producer=" + super.getProducer() +  "priceOut=" + priceOut + ", countryOut=" + countryOut + "]";
	}
	
	@Override
	public String getInfoToCSV() {
		return super.getId() + "," + super.getCode() + " , " + super.getName() + " , " + super.getPrice() + " , " + super.getQuanitity() + " , " + super.getProducer() + " , " + this.priceOut + " , " + this.countryOut ;
 
	}
	

}
