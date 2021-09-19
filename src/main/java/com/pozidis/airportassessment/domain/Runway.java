package com.pozidis.airportassessment.domain;

/**
 * @author arist
 */

public class Runway {
    private long id;
    private Airport airportRef;
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

    public Runway() {
    }

    public Runway(Airport airport, String airportIdent, int lengthFt, int widthFt, String surface, boolean lighted,
                  boolean closed, String leIdent, String leLatitudeDeg, String leLongitudeDeg, String leElevationFt,
                  String leHeadingDegT, String leDisplacedThresholdFt, String heIdent, String heLatitudeDeg, String heLongitudeDeg,
                  String heElevationFt, String heHeadingDegT, String heDisplacedThresholdFt) {
        this.airportRef = airport;
        this.airportIdent = airportIdent;
        this.lengthFt = lengthFt;
        this.widthFt = widthFt;
        this.surface = surface;
        this.lighted = lighted;
        this.closed = closed;
        this.leIdent = leIdent;
        this.leLatitudeDeg = leLatitudeDeg;
        this.leLongitudeDeg = leLongitudeDeg;
        this.leElevationFt = leElevationFt;
        this.leHeadingDegT = leHeadingDegT;
        this.leDisplacedThresholdFt = leDisplacedThresholdFt;
        this.heIdent = heIdent;
        this.heLatitudeDeg = heLatitudeDeg;
        this.heLongitudeDeg = heLongitudeDeg;
        this.heElevationFt = heElevationFt;
        this.heHeadingDegT = heHeadingDegT;
        this.heDisplacedThresholdFt = heDisplacedThresholdFt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Airport getAirportRef() {
        return airportRef;
    }

    public void setAirportRef(Airport airport) {
        this.airportRef = airport;
    }

    public String getAirportIdent() {
        return airportIdent;
    }

    public void setAirportIdent(String airportIdent) {
        this.airportIdent = airportIdent;
    }

    public int getLengthFt() {
        return lengthFt;
    }

    public void setLengthFt(int lengthFt) {
        this.lengthFt = lengthFt;
    }

    public int getWidthFt() {
        return widthFt;
    }

    public void setWidthFt(int widthFt) {
        this.widthFt = widthFt;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public boolean isLighted() {
        return lighted;
    }

    public void setLighted(boolean lighted) {
        this.lighted = lighted;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getLeIdent() {
        return leIdent;
    }

    public void setLeIdent(String leIdent) {
        this.leIdent = leIdent;
    }

    public String getLeLatitudeDeg() {
        return leLatitudeDeg;
    }

    public void setLeLatitudeDeg(String leLatitudeDeg) {
        this.leLatitudeDeg = leLatitudeDeg;
    }

    public String getLeLongitudeDeg() {
        return leLongitudeDeg;
    }

    public void setLeLongitudeDeg(String leLongitudeDeg) {
        this.leLongitudeDeg = leLongitudeDeg;
    }

    public String getLeElevationFt() {
        return leElevationFt;
    }

    public void setLeElevationFt(String leElevationFt) {
        this.leElevationFt = leElevationFt;
    }

    public String getLeHeadingDegT() {
        return leHeadingDegT;
    }

    public void setLeHeadingDegT(String leHeadingDegT) {
        this.leHeadingDegT = leHeadingDegT;
    }

    public String getLeDisplacedThresholdFt() {
        return leDisplacedThresholdFt;
    }

    public void setLeDisplacedThresholdFt(String leDisplacedThresholdFt) {
        this.leDisplacedThresholdFt = leDisplacedThresholdFt;
    }

    public String getHeIdent() {
        return heIdent;
    }

    public void setHeIdent(String heIdent) {
        this.heIdent = heIdent;
    }

    public String getHeLatitudeDeg() {
        return heLatitudeDeg;
    }

    public void setHeLatitudeDeg(String heLatitudeDeg) {
        this.heLatitudeDeg = heLatitudeDeg;
    }

    public String getHeLongitudeDeg() {
        return heLongitudeDeg;
    }

    public void setHeLongitudeDeg(String heLongitudeDeg) {
        this.heLongitudeDeg = heLongitudeDeg;
    }

    public String getHeElevationFt() {
        return heElevationFt;
    }

    public void setHeElevationFt(String heElevationFt) {
        this.heElevationFt = heElevationFt;
    }

    public String getHeHeadingDegT() {
        return heHeadingDegT;
    }

    public void setHeHeadingDegT(String heHeadingDegT) {
        this.heHeadingDegT = heHeadingDegT;
    }

    public String getHeDisplacedThresholdFt() {
        return heDisplacedThresholdFt;
    }

    public void setHeDisplacedThresholdFt(String heDisplacedThresholdFt) {
        this.heDisplacedThresholdFt = heDisplacedThresholdFt;
    }
}
