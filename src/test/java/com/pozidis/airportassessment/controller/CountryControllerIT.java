package com.pozidis.airportassessment.controller;

import com.pozidis.airportassessment.repository.CountryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author arist
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:db/migration/V0002__Table_Creation.sql")
class CountryControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    @DisplayName("Get successful response with a country name provided.")
    void getRunwaysByCountryName() throws Exception {
        int numOfTopCountries = 10;

        mockMvc.perform(get(String.format("/country/topCountriesByNumberOfAirports?countriesNumber=%d", numOfTopCountries))
                .contentType("application/json"))
                .andExpect(status().is2xxSuccessful());

        assertThat(countryRepository.getTopCountriesByNumberOfAirports(numOfTopCountries)).isNotEmpty();
    }

}