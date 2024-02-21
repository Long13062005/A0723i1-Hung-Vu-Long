package com.hvl.mvcdemo.models.repository;

import com.hvl.mvcdemo.models.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean add(Product product);
    boolean delete(String name);
    boolean update(String name,Product product);

}
