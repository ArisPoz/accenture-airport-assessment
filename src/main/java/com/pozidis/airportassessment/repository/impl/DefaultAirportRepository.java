package com.pozidis.airportassessment.repository.impl;

import com.pozidis.airportassessment.domain.Airport;
import com.pozidis.airportassessment.domain.rowMappers.AirportRowMapper;
import com.pozidis.airportassessment.repository.AirportRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author arist
 */

@Repository
public class DefaultAirportRepository implements AirportRepository {

    private final JdbcTemplate jdbcTemplate;
    private final AirportRowMapper airportRowMapper;

    public DefaultAirportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.airportRowMapper = new AirportRowMapper();
    }

    @Override
    public Airport getByName(String name) {
        return jdbcTemplate.queryForObject(
                String.format("SELECT * FROM AIRPORT WHERE NAME = '%s'", name), airportRowMapper);
    }
}