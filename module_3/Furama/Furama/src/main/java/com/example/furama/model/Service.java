package com.example.furama.model;

public class Service {
    private String service_name;
    private String service_area;
    private double service_cost;
    private int service_max_people;
    private int rent_type_id;

    public Service(String service_name, String service_area, double service_cost, int service_max_people, int rent_type_id) {
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_max_people = service_max_people;
        this.rent_type_id = rent_type_id;
    }

    @Override
    public String toString() {
        return "Service{" +
                "service_name='" + service_name + '\'' +
                ", service_area='" + service_area + '\'' +
                ", service_cost=" + service_cost +
                ", service_max_people=" + service_max_people +
                ", rent_type_id=" + rent_type_id +
                '}';
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_area() {
        return service_area;
    }

    public void setService_area(String service_area) {
        this.service_area = service_area;
    }

    public double getService_cost() {
        return service_cost;
    }

    public void setService_cost(double service_cost) {
        this.service_cost = service_cost;
    }

    public int getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(int service_max_people) {
        this.service_max_people = service_max_people;
    }

    public int getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(int rent_type_id) {
        this.rent_type_id = rent_type_id;
    }
}
