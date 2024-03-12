package com.codegym.demo_product.model;

public class Product {
    private int id;
    private String code;
    private String name;
    private String unit;
    private float price;
    private  int type_id;

    public Product() {
    }

    public Product(int id, String code, String name, String unit, float price, int type_id) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.type_id = type_id;
    }

    public Product(String code, String name, String unit, float price, int typeId) {
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.type_id = typeId;
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

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
}
