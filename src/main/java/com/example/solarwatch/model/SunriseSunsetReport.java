package com.example.solarwatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SunriseSunsetReport(LocalDate sunrise, LocalDate sunset) {
}
