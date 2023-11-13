package Product.repo;

import Product.model.Product;

public interface IProductRepo {
	Product[] getAll();
	void add(Product p);
}
