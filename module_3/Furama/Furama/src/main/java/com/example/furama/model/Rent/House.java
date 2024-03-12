package com.example.furama.model.Rent;

import com.example.furama.model.Service;

public class House extends Service {

    private String standard_room;
    private String description_other_convenience;
    private int number_of_floors;

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    public House(String service_name, String service_area, double service_cost, int service_max_people, int rent_type_id, String standard_room, String description_other_convenience, int number_of_floors) {
        super(service_name, service_area, service_cost, service_max_people, rent_type_id);
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.number_of_floors = number_of_floors;
    }

    public House(String service_name, String service_area, double service_cost, int service_max_people, int rent_type_id) {
        super(service_name, service_area, service_cost, service_max_people, rent_type_id);
    }

    @Override
    public String toString() {
        return "House{" +
                "standard_room='" + standard_room + '\'' +
                ", description_other_convenience='" + description_other_convenience + '\'' +
                ", number_of_floors=" + number_of_floors +
                '}';
    }
}
