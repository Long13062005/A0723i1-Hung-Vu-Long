package com.codegym.demo_product.repository;

import com.codegym.demo_product.model.ProductType;

import java.util.List;

public interface IProductTypeRepository {
    List<ProductType> findAll();
}
