package com.pozidis.airportassessment.repository.impl;

import com.pozidis.airportassessment.domain.Runway;
import com.pozidis.airportassessment.domain.rowMappers.RunwayRowMapper;
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
                String.format("SELECT r.* " +
                        "FROM AIRPORT as a, COUNTRY as c, RUNWAY as r " +
                        "WHERE a.ID= r.AIRPORT_REF AND a.ISO_COUNTRY = c.CODE AND c.NAME= '%s'", name), runwayRowMapper);
    }

    @Override
    public List<Runway> getRunwaysByCountryCode(String code) {
        return jdbcTemplate.query(
                String.format("SELECT r.* " +
                        "FROM AIRPORT as a, COUNTRY as c, RUNWAY as r " +
                        "WHERE a.ID= r.AIRPORT_REF AND a.ISO_COUNTRY = c.CODE AND c.CODE= '%s'", code), runwayRowMapper);
    }
}
