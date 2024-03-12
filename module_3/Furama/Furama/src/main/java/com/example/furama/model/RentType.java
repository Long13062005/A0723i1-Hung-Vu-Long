package com.example.furama.model;

public class RentType {
    private int rent_tyoe_id;
    private String rent_type_name;

    @Override
    public String toString() {
        return "RentType{" +
                "rent_tyoe_id=" + rent_tyoe_id +
                ", rent_type_name='" + rent_type_name + '\'' +
                '}';
    }

    public int getRent_tyoe_id() {
        return rent_tyoe_id;
    }

    public void setRent_tyoe_id(int rent_tyoe_id) {
        this.rent_tyoe_id = rent_tyoe_id;
    }

    public String getRent_type_name() {
        return rent_type_name;
    }

    public void setRent_type_name(String rent_type_name) {
        this.rent_type_name = rent_type_name;
    }

    public RentType() {
    }

    public RentType(int rent_tyoe_id, String rent_type_name) {
        this.rent_tyoe_id = rent_tyoe_id;
        this.rent_type_name = rent_type_name;
    }
}
