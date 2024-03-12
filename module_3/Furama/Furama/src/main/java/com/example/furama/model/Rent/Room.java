package com.example.furama.model.Rent;

import com.example.furama.model.Service;

public class Room extends Service {

    private String bonus_service;

    public Room(String service_name, String service_area, double service_cost, int service_max_people, int rent_type_id) {
        super(service_name, service_area, service_cost, service_max_people, rent_type_id);
    }

    public Room(String service_name, String service_area, double service_cost, int service_max_people, int rent_type_id, String bonus_service) {
        super(service_name, service_area, service_cost, service_max_people, rent_type_id);
        this.bonus_service = bonus_service;
    }

    public String getBonus_service() {
        return bonus_service;
    }

    public void setBonus_service(String bonus_service) {
        this.bonus_service = bonus_service;
    }

    @Override
    public String toString() {
        return "Room{" +
                "bonus_service='" + bonus_service + '\'' +
                '}';
    }
}
