package com.pozidis.airportassessment.repository;

import com.pozidis.airportassessment.domain.Airport;

/**
 * @author arist
 */

public interface AirportRepository{
    Airport getByName(String name);
}
