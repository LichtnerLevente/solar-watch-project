package com.example.solarwatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OpenWeatherReportCoordinates(double lat, double lon) {
}
