package com.codegym.demo_product.service;

import com.codegym.demo_product.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();
}
