package com.pozidis.airportassessment.repository.mapper;

import com.pozidis.airportassessment.domain.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author arist
 */

public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("ID");
        String code = resultSet.getString("CODE");
        String name = resultSet.getString("NAME");
        String continent = resultSet.getString("CONTINENT");
        String wikipediaLink = resultSet.getString("WIKIPEDIA_LINK");
        String keywords = resultSet.getString("KEYWORDS");

        return new Country(id, code, name, continent, wikipediaLink, keywords);
    }
}
