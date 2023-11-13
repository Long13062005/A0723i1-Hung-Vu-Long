package Product.service;

import Product.model.Product;

public interface IProductService {
	Product[] getAll();
	void add(Product p);
}
