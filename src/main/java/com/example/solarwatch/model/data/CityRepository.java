package com.example.solarwatch.model.data;

import com.example.solarwatch.model.SunriseSunsetResults;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByName(String name);

}
