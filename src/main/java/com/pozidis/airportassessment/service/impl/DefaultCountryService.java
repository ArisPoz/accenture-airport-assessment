package com.pozidis.airportassessment.service.impl;

import com.pozidis.airportassessment.domain.Country;
import com.pozidis.airportassessment.exception.ElementNotFoundException;
import com.pozidis.airportassessment.repository.CountryRepository;
import com.pozidis.airportassessment.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author arist
 */

@Service
public class DefaultCountryService implements CountryService {
    private final CountryRepository countryRepository;

    public DefaultCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getTopCountriesByNumberOfAirports(int top) {
        List<Country> topCountriesByNumberOfAirports = countryRepository.getTopCountriesByNumberOfAirports(top);

        if (topCountriesByNumberOfAirports.isEmpty())
            throw new ElementNotFoundException("Didn't find any country with airports");

        return topCountriesByNumberOfAirports;
    }
}
