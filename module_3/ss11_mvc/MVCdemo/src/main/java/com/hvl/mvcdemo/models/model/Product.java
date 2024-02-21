package com.hvl.mvcdemo.models.model;

public class Product {
    // Properties
    private String name;
    private double price;
    private int quantity;

    // Constructor

    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s - Price: $%.2f - Quantity: %d - Total: $%.2f", name, price, quantity, getTotal());
    }


}

