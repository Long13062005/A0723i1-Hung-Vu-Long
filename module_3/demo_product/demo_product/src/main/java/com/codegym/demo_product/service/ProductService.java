package com.codegym.demo_product.service;

import com.codegym.demo_product.dto.ProductDto;
import com.codegym.demo_product.model.Product;
import com.codegym.demo_product.repository.IProductRepository;
import com.codegym.demo_product.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductDto> search(String name, String searchTypeName) {
        return productRepository.search(name, searchTypeName);
    }

    @Override
    public boolean add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }
}
