package com.pozidis.airportassessment.repository;

import com.pozidis.airportassessment.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author arist
 */

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    @Query("SELECT a FROM Airport a WHERE a.name like ?1")
    Airport getByName(String name);
}
