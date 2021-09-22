package com.pozidis.airportassessment.domain;

import lombok.*;

/**
 * @author arist
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Runway {
    private long id;
    private long airportRef;
    private String airportIdent;
    private int lengthFt;
    private int widthFt;
    private String surface;
    private boolean lighted;
    private boolean closed;
    private String leIdent;
    private String leLatitudeDeg;
    private String leLongitudeDeg;
    private String leElevationFt;
    private String leHeadingDegT;
    private String leDisplacedThresholdFt;
    private String heIdent;
    private String heLatitudeDeg;
    private String heLongitudeDeg;
    private String heElevationFt;
    private String heHeadingDegT;
    private String heDisplacedThresholdFt;
}
