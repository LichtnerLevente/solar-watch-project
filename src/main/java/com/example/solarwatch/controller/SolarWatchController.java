package com.example.solarwatch.controller;

import com.example.solarwatch.model.OpenWeatherReport;
import com.example.solarwatch.model.SunriseSunsetResults;
import com.example.solarwatch.model.data.City;
import com.example.solarwatch.model.data.CityRepository;
import com.example.solarwatch.service.SunsetSunriseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolarWatchController {

    private final SunsetSunriseService sunsetSunriseService;

    private final CityRepository cityRepository;

    public SolarWatchController(SunsetSunriseService sunsetSunriseService, CityRepository cityRepository) {
        this.sunsetSunriseService = sunsetSunriseService;
        this.cityRepository = cityRepository;
    }

    @GetMapping("/solarwatch")
    public ResponseEntity getSolarTimesByCity(String city){
        if(city == null){
            return ResponseEntity.badRequest().body("Invalid city name");
        }

        City cityObject = cityRepository.findByName(city).orElse(null);

        if (cityObject != null){
            SunriseSunsetResults results = sunsetSunriseService.getSunriseSunsetForCity(cityObject);
            cityRepository.save(cityObject);
            System.out.println("City Object saved to DB");
            return ResponseEntity.ok(results);
        }

        SunriseSunsetResults results = sunsetSunriseService.getSunriseSunsetForCity(city);


        return ResponseEntity.ok(results);
    }
}
