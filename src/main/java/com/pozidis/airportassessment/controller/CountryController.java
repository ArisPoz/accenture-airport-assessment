package com.pozidis.airportassessment.controller;

import com.pozidis.airportassessment.domain.Country;
import com.pozidis.airportassessment.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author arist
 */

@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/topCountriesByNumberOfAirports")
    public List<Country> getTopCountriesByNumberOfAirports(int countriesNumber) {
        return countryService.getTopCountriesByNumberOfAirports(countriesNumber);
    }
}
