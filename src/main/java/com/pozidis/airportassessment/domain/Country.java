package com.pozidis.airportassessment.domain;

import lombok.*;

/**
 * @author arist
 */

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Country {
    private long id;
    private String code;
    private String name;
    private String continent;
    private String wikipediaLink;
    private String keywords;
}
