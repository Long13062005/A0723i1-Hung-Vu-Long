package com.codegym.demo_product.service;

import com.codegym.demo_product.dto.ProductDto;
import com.codegym.demo_product.model.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> findAll();
    List<ProductDto> search(String name,String searchTypeName);
    boolean add(Product product);
    boolean delete(int id);
}
