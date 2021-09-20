package com.pozidis.airportassessment.repository.impl;

import com.pozidis.airportassessment.domain.Country;
import com.pozidis.airportassessment.domain.rowMappers.CountryRowMapper;
import com.pozidis.airportassessment.repository.CountryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author arist
 */

@Repository
public class DefaultCountryRepository implements CountryRepository {

    private final JdbcTemplate jdbcTemplate;
    private final CountryRowMapper countryRowMapper;

    public DefaultCountryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.countryRowMapper = new CountryRowMapper();
    }

    @Override
    public List<Country> getTopCountriesByNumberOfAirports(int numberOfCountries) {
        return jdbcTemplate.query(String.format("SELECT COUNTRY.*" +
                "FROM AIRPORT, COUNTRY " +
                "WHERE AIRPORT.ISO_COUNTRY = COUNTRY.CODE " +
                "GROUP BY COUNTRY.CODE " +
                "ORDER BY COUNT(*) DESC " +
                "LIMIT %s", numberOfCountries), countryRowMapper);
    }
}
