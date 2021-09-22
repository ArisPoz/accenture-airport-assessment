package com.pozidis.airportassessment.service;

import com.pozidis.airportassessment.domain.Runway;

import java.util.List;

/**
 * @author arist
 */
public interface RunwayService {
    List<Runway> getRunwaysByCountryName(String name);

    List<Runway> getRunwaysByCountryCode(String code);
}
