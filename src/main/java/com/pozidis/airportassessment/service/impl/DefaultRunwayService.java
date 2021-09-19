package com.pozidis.airportassessment.service.impl;

import com.pozidis.airportassessment.domain.Runway;
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
        return runwayRepository.getRunwaysByCountryName(name);
    }

    @Override
    public List<Runway> getRunwaysByCountryCode(String code) {
        return runwayRepository.getRunwaysByCountryCode(code);
    }
}
