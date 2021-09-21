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
public class Country {
    private long id;
    private String code;
    private String name;
    private String continent;
    private String wikipediaLink;
    private String keywords;
}
