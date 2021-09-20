package com.pozidis.airportassessment.service;

import com.pozidis.airportassessment.domain.Country;

import java.util.List;

/**
 * @author arist
 */
public interface CountryService {
    List<Country> getTopCountriesByNumberOfAirports(int top);
}
