package com.pozidis.airportassessment.service.impl;

import com.pozidis.airportassessment.domain.Runway;
import com.pozidis.airportassessment.exception.BadRequestException;
import com.pozidis.airportassessment.exception.ElementNotFoundException;
import com.pozidis.airportassessment.repository.RunwayRepository;
import com.pozidis.airportassessment.service.RunwayService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author arist
 */

@ExtendWith(MockitoExtension.class)
class RunwayServiceTest {

    @Mock
    private RunwayRepository runwayRepository;

    private RunwayService runwayService;

    @BeforeEach
    void setUp() {
        runwayService = new DefaultRunwayService(runwayRepository);
    }

    @Test
    void givenValidCountryNameGetRunwaysTest() {
        // given
        Mockito.when(runwayRepository.getRunwaysByCountryName("GREECE")).thenReturn(getRunways());
        String countryName = "GREECE";

        // when
        List<Runway> runways = runwayService.getRunwaysByCountryName(countryName);

        // then
        assertThat(runways).isNotEmpty().hasSize(2).contains(getRunways().get(0)).contains(getRunways().get(1));
    }

    @Test
    void givenValidCountryCodeGetRunwaysTest() {
        // given
        Mockito.when(runwayRepository.getRunwaysByCountryCode("GR")).thenReturn(getRunways());
        String countryCode = "GR";

        // when
        List<Runway> runways = runwayService.getRunwaysByCountryCode(countryCode);

        // then
        assertThat(runways).isNotEmpty().hasSize(2).contains(getRunways().get(0)).contains(getRunways().get(1));
    }

    @Test
    void givenEmptyCountryNameGetBadRequestExceptionTest() {
        //given
        String emptyName = "";

        // when then
        Assertions.assertThrows(BadRequestException.class,
                () -> runwayService.getRunwaysByCountryName(emptyName));
    }

    @Test
    void givenEmptyCountryCodeGetBadRequestExceptionTest() {
        //given
        String emptyCode = "";

        // when then
        Assertions.assertThrows(BadRequestException.class,
                () -> runwayService.getRunwaysByCountryCode(emptyCode));
    }

    @Test
    void givenNonExistingCountryNameGetElementNotFoundExceptionTest() {
        // given
        String nonExistingCountry = "404 Country";

        // when then
        Assertions.assertThrows(ElementNotFoundException.class,
                () -> runwayService.getRunwaysByCountryName(nonExistingCountry));
    }

    @Test
    void givenNonExistingCountryCodeGetElementNotFoundExceptionTest() {
        // given
        String nonExistingCode = "404 Code";

        // when then
        Assertions.assertThrows(ElementNotFoundException.class,
                () -> runwayService.getRunwaysByCountryName(nonExistingCode));
    }

    private List<Runway> getRunways() {
        List<Runway> runways = new ArrayList<>();
        runways.add(new Runway(1, 1000, "GR", 10, 50, "Surface", true,
                false, "", "", "", "", "", "",
                "", "", "", "", "", ""));
        runways.add(new Runway(2, 2000, "GR", 100, 150, "Surface2", true,
                false, "", "", "", "", "", "",
                "", "", "", "", "", ""));

        return runways;
    }
}