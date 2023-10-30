package com.example.solarwatch.service;

import com.example.solarwatch.model.OpenWeatherReport;
import com.example.solarwatch.model.SunriseSunsetReport;
import com.example.solarwatch.model.SunriseSunsetResults;
import com.example.solarwatch.model.data.City;
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
    private OpenWeatherReport getCoordinatesByCityName(String cityName){
        String url = String.format("https://api.openweathermap.org/geo/1.0/direct?q=%s&limit=1&appid=%s", cityName, API_KEY);

        OpenWeatherReport[] response = restTemplate.getForObject(url, OpenWeatherReport[].class);
        assert response != null;
        System.out.println(Arrays.toString(response));
        return response[0];
    }
    private SunriseSunsetResults getSunriseByCoordinates(OpenWeatherReport openWeatherReport){
        String url = String.format("https://api.sunrise-sunset.org/json?lat=%f&lng=%f", openWeatherReport.lat(), openWeatherReport.lon());

        SunriseSunsetReport response = restTemplate.getForObject(url, SunriseSunsetReport.class);
        System.out.println(response);
        assert response != null;
        return response.results();

    }
    public SunriseSunsetResults getSunriseSunsetForCity(City city){
        System.out.println(city.toString());
        return new SunriseSunsetResults(city.getSunrise(), city.getSunset());
    }
    public SunriseSunsetResults getSunriseSunsetForCity(String city){
        return getSunriseByCoordinates(getCoordinatesByCityName(city));
    }
}
