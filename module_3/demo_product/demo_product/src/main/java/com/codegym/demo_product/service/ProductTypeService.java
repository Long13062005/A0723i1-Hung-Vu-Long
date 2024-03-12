package com.codegym.demo_product.service;

import com.codegym.demo_product.model.ProductType;
import com.codegym.demo_product.repository.IProductTypeRepository;
import com.codegym.demo_product.repository.ProductTypeRepository;

import java.util.List;

public class ProductTypeService implements IProductTypeService{
    private IProductTypeRepository productTypeRepository = new ProductTypeRepository();
    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
}
