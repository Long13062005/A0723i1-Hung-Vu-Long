package com.codegym.demo_product.repository;

import com.codegym.demo_product.dto.ProductDto;
import com.codegym.demo_product.model.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeRepository implements IProductTypeRepository{
    private final String All = "select * from product_type";

    @Override
    public List<ProductType> findAll() {
        List<ProductType> productTypeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(All);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                ProductType productType = new ProductType(id,name);
                productTypeList.add(productType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productTypeList;
    }
}
