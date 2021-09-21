package com.pozidis.airportassessment.controller;

import com.pozidis.airportassessment.domain.Country;
import com.pozidis.airportassessment.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author arist
 */

@RestController
@RequestMapping("/country/")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/topCountriesByNumberOfAirports", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Country> getTopCountriesByNumberOfAirports(@RequestParam int countriesNumber) {
        return countryService.getTopCountriesByNumberOfAirports(countriesNumber);
    }
}
