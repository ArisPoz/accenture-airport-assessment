package com.pozidis.airportassessment.service.impl;

import com.pozidis.airportassessment.domain.Airport;
import com.pozidis.airportassessment.repository.AirportRepository;
import com.pozidis.airportassessment.service.AirportService;
import org.springframework.stereotype.Service;

/**
 * @author arist
 */

@Service
public class DefaultAirportService implements AirportService {

    private final AirportRepository airportRepository;

    public DefaultAirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport getAirportByName(String name) {
        return airportRepository.getByName(name);
    }
}
