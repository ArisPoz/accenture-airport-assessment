package com.pozidis.airportassessment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author arist
 */

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@Sql(scripts = "classpath:testDB.sql")
class CountryControllerIT {

    private static final String BASE_URI = "/v1/countries/top/by-airports";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getTopCountriesByNumberOfAirportTest() throws Exception {
        // given
        int numOfCountries = 2;
        int expectedRecordId1 = 1;
        int expectedRecordId2 = 2;

        // when then
        mockMvc.perform(get(String.format("%s?numOfCountries=%d", BASE_URI, numOfCountries))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(numOfCountries)))
                .andExpect(jsonPath("$[0].id").value(expectedRecordId1))
                .andExpect(jsonPath("$[1].id").value(expectedRecordId2));
    }

    @Test
    void getWithoutTopCountriesExistResultInElementNotFoundException() throws Exception {
        // given
        int numOfCountries = 0;

        // when then
        mockMvc.perform(get(String.format("%s?numOfCountries=%d", BASE_URI, numOfCountries))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}