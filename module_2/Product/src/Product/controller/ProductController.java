package Product.controller;

import Product.model.Product;
import Product.service.IProductService;
import Product.service.ProductService;

public class ProductController {
	private IProductService sv = new ProductService();
	public Product[] getAll() {
		return sv.getAll();
	}
	public void add(Product p) {
		sv.add(p);
	}
}	
