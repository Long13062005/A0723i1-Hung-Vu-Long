package com.example.product.model;

import jakarta.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String typePhone;
    private String description;


    public Phone(Integer id, String typePhone, String description) {
        this.id = id;
        this.typePhone = typePhone;
        this.description = description;
    }

    public Phone(Integer id) {
        this.id = id;
    }

    public String getTypePhone() {
        return typePhone;
    }

    public void setTypePhone(String typePhone) {
        this.typePhone = typePhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Phone() {
    }
}
