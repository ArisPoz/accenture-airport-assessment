package com.pozidis.airportassessment.service.impl;

import com.pozidis.airportassessment.domain.Runway;
import com.pozidis.airportassessment.exception.BadRequestException;
import com.pozidis.airportassessment.exception.ElementNotFoundException;
import com.pozidis.airportassessment.repository.RunwayRepository;
import com.pozidis.airportassessment.service.RunwayService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author arist
 */

@Service
public class DefaultRunwayService implements RunwayService {
    private final RunwayRepository runwayRepository;

    public DefaultRunwayService(RunwayRepository runwayRepository) {
        this.runwayRepository = runwayRepository;
    }

    @Override
    public List<Runway> getRunwaysByCountryName(String name) {
        if (name.isEmpty())
            throw new BadRequestException("Country name must be provided.");

        List<Runway> runways = runwayRepository.getRunwaysByCountryName(name);

        if (runways.isEmpty())
            throw new ElementNotFoundException(String.format("No runways found for country with name: %s", name));

        return runways;
    }

    @Override
    public List<Runway> getRunwaysByCountryCode(String code) {
        if (code.isEmpty())
            throw new BadRequestException("Country code must be provided.");

        List<Runway> runways = runwayRepository.getRunwaysByCountryCode(code);

        if (runways.isEmpty())
            throw new ElementNotFoundException(String.format("No runways found for country with code: %s.", code));

        return runways;
    }
}
