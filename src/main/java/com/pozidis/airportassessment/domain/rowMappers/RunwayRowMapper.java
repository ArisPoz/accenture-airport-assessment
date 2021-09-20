package com.pozidis.airportassessment.domain.rowMappers;

import com.pozidis.airportassessment.domain.Runway;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author arist
 */
public class RunwayRowMapper implements RowMapper<Runway> {
    @Override
    public Runway mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("ID");
        long airportRef = resultSet.getLong("AIRPORT_REF");
        String airportIdent = resultSet.getString("AIRPORT_IDENT");
        int lengthFt = resultSet.getInt("LENGTH_FT");
        int widthFt = resultSet.getInt("WIDTH_FT");
        String surface = resultSet.getString("SURFACE");
        boolean lighted = resultSet.getBoolean("LIGHTED");
        boolean closed = resultSet.getBoolean("CLOSED");
        String leIdent = resultSet.getString("LE_IDENT");
        String leLatitudeDeg = resultSet.getString("LE_LATITUDE_DEG");
        String leLongitudeDeg = resultSet.getString("LE_LONGITUDE_DEG");
        String leElevationFt = resultSet.getString("LE_ELEVATION_FT");
        String leHeadingDegT = resultSet.getString("LE_HEADING_DEGT");
        String leDisplacedThresholdFt = resultSet.getString("LE_DISPLACED_THRESHOLD_FT");
        String heIdent = resultSet.getString("HE_IDENT");
        String heLatitudeDeg = resultSet.getString("HE_LATITUDE_DEG");
        String heLongitudeDeg = resultSet.getString("HE_LONGITUDE_DEG");
        String heElevationFt = resultSet.getString("HE_ELEVATION_FT");
        String heHeadingDegT = resultSet.getString("HE_HEADING_DEGT");
        String heDisplacedThresholdFt = resultSet.getString("HE_DISPLACED_THRESHOLD_FT");

        Runway runway = new Runway(airportRef, airportIdent, lengthFt, widthFt, surface, lighted, closed, leIdent,
                leLatitudeDeg, leLongitudeDeg, leElevationFt, leHeadingDegT, leDisplacedThresholdFt, heIdent,
                heLatitudeDeg, heLongitudeDeg, heElevationFt, heHeadingDegT, heDisplacedThresholdFt);
        runway.setId(id);

        return runway;
    }
}
