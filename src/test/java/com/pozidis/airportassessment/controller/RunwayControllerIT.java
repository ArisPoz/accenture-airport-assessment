package com.pozidis.airportassessment.controller;

import com.pozidis.airportassessment.repository.RunwayRepository;
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
class RunwayControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RunwayRepository runwayRepository;

    @Test
    @DisplayName("Get successful response with a country name provided.")
    void getRunwaysByCountryName() throws Exception {
        String name = "Greece";

        mockMvc.perform(get(String.format("/runway/runwaysByCountryName?name=%s", name))
                .contentType("application/json"))
                .andExpect(status().is2xxSuccessful());

        assertThat(runwayRepository.getRunwaysByCountryName(name)).isNotEmpty();
    }

    @Test
    @DisplayName("Get successful response with a country code provided.")
    void getRunwaysByCountryCode() throws Exception {
        String code = "Gr";

        mockMvc.perform(get(String.format("/runway/runwaysByCountryCode?code=%s", code))
                .contentType("application/json"))
                .andExpect(status().is2xxSuccessful());

        assertThat(runwayRepository.getRunwaysByCountryCode(code)).isNotEmpty();
    }
}