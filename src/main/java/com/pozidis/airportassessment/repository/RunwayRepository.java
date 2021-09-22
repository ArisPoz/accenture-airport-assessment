package com.pozidis.airportassessment.repository;

import com.pozidis.airportassessment.domain.Runway;

import java.util.List;

/**
 * @author arist
 */
public interface RunwayRepository {
    List<Runway> getRunwaysByCountryName(String name);

    List<Runway> getRunwaysByCountryCode(String code);
}
