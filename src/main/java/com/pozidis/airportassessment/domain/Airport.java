package com.pozidis.airportassessment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author arist
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
    private long id;
    private String ident;
    private String type;
    private String name;
    private double latitudeDeg;
    private double longitudeDeg;
    private String elevationFt;
    private String continent;
    private String isoCountry;
    private String isoRegion;
    private String municipality;
    private String scheduledService;
    private String gpsCode;
    private String iataCode;
    private String localCode;
    private String homeLink;
    private String wikipediaLink;
    private String keywords;
}
