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
@Sql(scripts = "classpath:testDB.sql")
@TestPropertySource(locations = "classpath:application-test.properties")
class RunwayControllerIT {

    private static final String BASE_URI = "/v1/runways";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRunwaysByCountryNameTest() throws Exception {
        // given
        String name = "GREECE";
        int expectedRecordId1 = 1;
        int expectedRecordId2 = 2;
        int responseSize = 2;

        // when then
        mockMvc.perform(get(String.format("%s/country-name?name=%s", BASE_URI, name))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(responseSize)))
                .andExpect(jsonPath("$[0].id").value(expectedRecordId1))
                .andExpect(jsonPath("$[1].id").value(expectedRecordId2));

    }

    @Test
    void getRunwaysByCountryCodeTest() throws Exception {
        // given
        String givenCode = "NL";
        int expectedRunwayID = 3;
        int responseSize = 1;

        // when then
        mockMvc.perform(get(String.format("%s/country-code?code=%s", BASE_URI, givenCode))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(responseSize)))
                .andExpect(jsonPath("$[0].id").value(expectedRunwayID));
    }

    @Test
    void getRunwaysWithoutCountryNameResultInBadRequestExceptionTest() throws Exception {
        // given
        String givenName = "";

        // when then
        mockMvc.perform(get(String.format("%s/country-name?name=%s", BASE_URI, givenName))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getRunwaysWithoutCountryCodeResultInBadRequestExceptionTest() throws Exception {
        // given
        String givenCode = "";

        // when then
        mockMvc.perform(get(String.format("%s/country-code?code=%s", BASE_URI, givenCode))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getRunwaysWithNonExistingCountryNameResultInBadRequestExceptionTest() throws Exception {
        // given
        String givenName = "404 Country";

        // when then
        mockMvc.perform(get(String.format("%s/country-name?name=%s", BASE_URI, givenName))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRunwaysWithNonExistingCountryCodeResultInElementNotFoundExceptionTest() throws Exception {
        // given
        String givenCode = "404 Code";

        // when then
        mockMvc.perform(get(String.format("%s/country-code?code=%s", BASE_URI, givenCode))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}