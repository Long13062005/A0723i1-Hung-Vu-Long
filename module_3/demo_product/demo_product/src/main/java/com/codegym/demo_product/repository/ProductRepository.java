package com.codegym.demo_product.repository;

import com.codegym.demo_product.dto.ProductDto;
import com.codegym.demo_product.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private final String All ="select p.*,pt.name as type_name from product p join product_type pt on p.type_id = pt.id;";
    private final String DELETE ="delete from product where id =?;";
    private final String INSERT ="insert into product(code,name,unit,price,type_id) values(?,?,?,?,?);";
    private final String SEARCH_ALL ="select p.*,pt.name as type_name from product p join product_type pt on p.type_id = pt.id where p.name like concat('%',?,'%') and pt.name like concat('%',?,'%');";
    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtoList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(All);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                String unit = resultSet.getString("unit");
                float price = resultSet.getFloat("price");
                String typeName = resultSet.getString("type_name");
                ProductDto productDto = new ProductDto(id,code,name,unit,price,typeName);
                productDtoList.add(productDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> search(String searchName, String searchTypeName) {
        List<ProductDto> productDtoList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ALL);
        preparedStatement.setString(1,searchName);
        preparedStatement.setString(2,searchTypeName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                String unit = resultSet.getString("unit");
                float price = resultSet.getFloat("price");
                String typeName = resultSet.getString("type_name");
                ProductDto productDto = new ProductDto(id,code,name,unit,price,typeName);
                productDtoList.add(productDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productDtoList;
    }

    @Override
    public boolean add(Product product) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, product.getCode());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getUnit());
            preparedStatement.setFloat(4, product.getPrice());
            preparedStatement.setInt(5, product.getType_id());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        }
    }
}
