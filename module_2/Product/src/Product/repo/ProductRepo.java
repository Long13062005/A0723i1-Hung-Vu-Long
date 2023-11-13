package Product.repo;

import Product.model.Product;

public class ProductRepo implements IProductRepo {
	private static Product[] po = new Product[10];
	@Override
	public Product[] getAll() {
		// TODO Auto-generated method stub
		return po;
	}

	@Override
	public void add(Product p) {
		// TODO Auto-generated method stub
		for (int i = 0; i < po.length;i++) {
			if(po[i] == null) {
				po[i] = p;
				break;
			}
		}
	}
	
}
