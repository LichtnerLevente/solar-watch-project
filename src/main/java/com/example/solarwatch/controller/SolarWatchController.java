package com.example.solarwatch.controller;

import com.example.solarwatch.model.Coordinates;
import com.example.solarwatch.model.SunriseSunsetReport;
import com.example.solarwatch.service.SunsetSunriseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolarWatchController {

    private final SunsetSunriseService sunsetSunriseService;

    public SolarWatchController(SunsetSunriseService sunsetSunriseService) {
        this.sunsetSunriseService = sunsetSunriseService;
    }

    @GetMapping("/solarwatch")
    public ResponseEntity getSolarTimesByCity(String city){
        if(city == null){
            return ResponseEntity.badRequest().body("Invalid city name");
        }

        Coordinates coordinates = sunsetSunriseService.getCoordinatesByCityName(city);
        SunriseSunsetReport response = sunsetSunriseService.getSunRiseByCoordinates(coordinates);
        return ResponseEntity.ok(response);
    }
}
