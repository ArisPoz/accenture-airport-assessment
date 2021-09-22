package com.pozidis.airportassessment.repository;

import com.pozidis.airportassessment.domain.Country;

import java.util.List;

/**
 * @author arist
 */
public interface CountryRepository {
    List<Country> getTopCountriesByNumberOfAirports(int top);
}
