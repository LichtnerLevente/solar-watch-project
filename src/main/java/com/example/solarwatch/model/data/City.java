package com.example.solarwatch.model.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class City {
    @Id @GeneratedValue
    private long id;

    private String name;
    private String state;
    private String country;
    private  double lon;
    private double lat;
    private String sunset;
    private String sunrise;

    public String getName() {
        return name;
    }


    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
