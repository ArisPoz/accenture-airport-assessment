package com.pozidis.airportassessment.domain.rowMappers;

import com.pozidis.airportassessment.domain.Airport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author arist
 */
public class AirportRowMapper implements RowMapper<Airport> {

    @Override
    public Airport mapRow(ResultSet resultSet, int index) throws SQLException {
        long id = resultSet.getLong("ID");
        String ident = resultSet.getString("IDENT");
        String type = resultSet.getString("TYPE");
        String name = resultSet.getString("NAME");
        double latitudeDeg = resultSet.getDouble("LATITUDE_DEG");
        double longitudeDeg = resultSet.getDouble("LONGITUDE_DEG");
        String elevationFt = resultSet.getString("ELEVATION_FT");
        String continent = resultSet.getString("CONTINENT");
        String isoCountry = resultSet.getString("ISO_COUNTRY");
        String isoRegion = resultSet.getString("ISO_REGION");
        String municipality = resultSet.getString("MUNICIPALITY");
        String scheduledService = resultSet.getString("SCHEDULED_SERVICE");
        String gpsCode = resultSet.getString("GPS_CODE");
        String iataCode = resultSet.getString("IATA_CODE");
        String localCode = resultSet.getString("LOCAL_CODE");
        String homeLink = resultSet.getString("HOME_LINK");
        String wikipediaLink = resultSet.getString("WIKIPEDIA_LINK");
        String keywords = resultSet.getString("KEYWORDS");

        Airport airport = new Airport(ident, type, name, latitudeDeg, longitudeDeg, elevationFt, continent,
                isoCountry, isoRegion, municipality, scheduledService, gpsCode, iataCode, localCode,
                homeLink, wikipediaLink, keywords);

        airport.setId(id);

        return airport;
    }
}
