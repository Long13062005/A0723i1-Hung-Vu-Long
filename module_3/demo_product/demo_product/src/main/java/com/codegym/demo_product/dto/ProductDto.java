package com.codegym.demo_product.dto;

public class ProductDto {
    private int id;
    private String code;
    private String name;
    private String unit;
    private float price;
    private String typeName;

    public ProductDto() {
    }

    public ProductDto(int id, String code, String name, String unit, float price, String type_name) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.typeName = type_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
