package com.hvl.mvcdemo.models.service;

import com.hvl.mvcdemo.models.model.Product;

import java.util.List;

public interface IProductService  {
    List<Product> findAll();
    boolean add(Product product);
    boolean delete(String name);
    Product findProduct(String name);
    void update(String name,Product product);

}
