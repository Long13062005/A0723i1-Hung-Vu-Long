package Product.service;

import Product.model.Product;
import Product.repo.*;

public class ProductService implements IProductService {
	private IProductRepo po = new ProductRepo();
	@Override
	public Product[] getAll() {
		// TODO Auto-generated method stub
		return po.getAll();
	}

	@Override
	public void add(Product p) {
		// TODO Auto-generated method stub
		po.add(p);
	}
	
}
