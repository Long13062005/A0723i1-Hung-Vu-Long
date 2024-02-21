package com.hvl.mvcdemo.models.service.imp;

import com.hvl.mvcdemo.models.model.Product;
import com.hvl.mvcdemo.models.repository.IProductRepository;
import com.hvl.mvcdemo.models.repository.imp.ProductRepository;
import com.hvl.mvcdemo.models.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public boolean delete(String name) {
        if(productRepository.checkExistProduct(name)){
            productRepository.delete(name);
            return true;
        }
        return false;
    }

    @Override
    public Product findProduct(String name) {
        return productRepository.findProduct(name);
    }

    @Override
    public void update(String name, Product product) {
        productRepository.update(name,product);
    }
}
