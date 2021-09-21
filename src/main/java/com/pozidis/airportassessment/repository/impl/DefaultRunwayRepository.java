package com.pozidis.airportassessment.repository.impl;

import com.pozidis.airportassessment.domain.Runway;
import com.pozidis.airportassessment.domain.mapper.RunwayRowMapper;
import com.pozidis.airportassessment.repository.RunwayRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author arist
 */

@Repository
public class DefaultRunwayRepository implements RunwayRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RunwayRowMapper runwayRowMapper;

    public DefaultRunwayRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.runwayRowMapper = new RunwayRowMapper();
    }

    @Override
    public List<Runway> getRunwaysByCountryName(String name) {
        return jdbcTemplate.query(
                String.format("SELECT RUNWAY.* FROM AIRPORT, COUNTRY, RUNWAY " +
                        "WHERE AIRPORT.ID= RUNWAY.AIRPORT_REF AND AIRPORT.ISO_COUNTRY = COUNTRY.CODE AND " +
                        "(LOWER(COUNTRY.NAME) LIKE LOWER('%1$s%%') AND DIFFERENCE(LOWER(COUNTRY.NAME), LOWER('%1$s')) >= 2)", name), runwayRowMapper);
    }

    @Override
    public List<Runway> getRunwaysByCountryCode(String code) {
        return jdbcTemplate.query(
                String.format("SELECT RUNWAY.* FROM AIRPORT, COUNTRY, RUNWAY " +
                        "WHERE AIRPORT.ID= RUNWAY.AIRPORT_REF AND AIRPORT.ISO_COUNTRY = COUNTRY.CODE AND " +
                        "(LOWER(COUNTRY.CODE) LIKE LOWER('%1$s%%') AND DIFFERENCE(LOWER(COUNTRY.CODE), LOWER('%1$s')) >= 2)", code), runwayRowMapper);
    }
}
