package com.example.solarwatch.service;

import com.example.solarwatch.model.Coordinates;
import com.example.solarwatch.model.OpenWeatherReportCoordinates;
import com.example.solarwatch.model.SunriseSunsetReport;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.logging.Logger;

@Service
public class SunsetSunriseService {
    private static final String API_KEY = "608960e017d9173ae60a3fc37309327a";

    private  static  final Logger logger = Logger.getLogger(String.valueOf(SunsetSunriseService.class));
    private final RestTemplate restTemplate;

    public SunsetSunriseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Coordinates getCoordinatesByCityName(String cityName){
        String url = String.format("https://api.openweathermap.org/geo/1.0/direct?q=%s&limit=1&appid=%s", cityName, API_KEY);

        OpenWeatherReportCoordinates[] response = restTemplate.getForObject(url, OpenWeatherReportCoordinates[].class);
        assert response != null;
        System.out.println(Arrays.toString(response));
        return new Coordinates(response[0].lat(), response[0].lon());
    }
    public SunriseSunsetReport getSunRiseByCoordinates(Coordinates coordinates){
        String url = String.format("https://api.sunrise-sunset.org/json?lat=%f&lng=%f", coordinates.lat(), coordinates.lng());

        System.out.println(restTemplate.getForObject(url, String.class));
        SunriseSunsetReport response = restTemplate.getForObject(url, SunriseSunsetReport.class);
        assert response != null;
        return response;

    }
}
