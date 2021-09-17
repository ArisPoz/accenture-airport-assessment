package com.pozidis.airportassessment.controller;

import com.pozidis.airportassessment.domain.Airport;
import com.pozidis.airportassessment.service.AirportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author arist
 */

@RestController
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/getAirport/{name}")
    public Airport getByName(@PathVariable String name) {
        return airportService.getAirportByName(name);
    }
}