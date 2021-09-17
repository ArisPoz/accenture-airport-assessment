package com.pozidis.airportassessment.service;

import com.pozidis.airportassessment.domain.Airport;

/**
 * @author arist
 */
public interface AirportService {
    Airport getAirportByName(String name);
}
