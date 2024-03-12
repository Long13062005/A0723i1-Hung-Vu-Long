package com.codegym.demo_product.repository;

import com.codegym.demo_product.dto.ProductDto;
import com.codegym.demo_product.model.Product;

import java.util.LinkedList;
import java.util.List;

public interface IProductRepository {
    List<ProductDto> findAll();
    List<ProductDto> search(String name,String searchTypeName);
    boolean add(Product product);
    boolean delete(int id);

}
