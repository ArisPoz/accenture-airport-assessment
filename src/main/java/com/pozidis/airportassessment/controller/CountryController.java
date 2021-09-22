package com.pozidis.airportassessment.controller;

import com.pozidis.airportassessment.domain.Country;
import com.pozidis.airportassessment.service.CountryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author arist
 */

@RestController
@RequestMapping("/v1/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/top/by-airports", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> getTopCountriesByNumberOfAirports(@RequestParam int numOfCountries) {
        return countryService.getTopCountriesByNumberOfAirports(numOfCountries);
    }
}
