package com.example.solarwatch.model.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class SunriseSunsetTimes {
    @Id
    @GeneratedValue
    private long id;
    private String cityName;
    private LocalDate date;
    private String sunrise;
    private String sunset;


}
