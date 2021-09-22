package com.pozidis.airportassessment.service.impl;

import com.pozidis.airportassessment.domain.Country;
import com.pozidis.airportassessment.exception.ElementNotFoundException;
import com.pozidis.airportassessment.repository.CountryRepository;
import com.pozidis.airportassessment.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author arist
 */

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {

    private static final int TOP_NUMBER_OF_COUNTRIES = 3;

    @Mock
    private CountryRepository countryRepository;

    private CountryService countryService;

    @BeforeEach
    void setUp() {
        countryService = new DefaultCountryService(countryRepository);
    }

    @Test
    void getTopCountriesByNumberOfAirportsShouldReturnAllAirports() {
        //given
        Mockito.when(countryRepository
                .getTopCountriesByNumberOfAirports(TOP_NUMBER_OF_COUNTRIES))
                .thenReturn(getCountries());

        // when
        List<Country> countries = countryService.getTopCountriesByNumberOfAirports(TOP_NUMBER_OF_COUNTRIES);

        // then
        assertThat(countries).isNotEmpty()
                .hasSize(3)
                .contains(getCountries().get(0))
                .contains(getCountries().get(1))
                .contains(getCountries().get(2));
    }

    @Test
    void getTopCountriesByNumberOfAirportsWithNoAirportsShouldThrowException() {
        //given
        Mockito.when(countryRepository
                .getTopCountriesByNumberOfAirports(TOP_NUMBER_OF_COUNTRIES))
                .thenReturn(new ArrayList<>());

        // when - then
        assertThrows(ElementNotFoundException.class,
                () -> countryService.getTopCountriesByNumberOfAirports(TOP_NUMBER_OF_COUNTRIES));
    }


    private List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country(1, "GR", "GREECE", "continent", "wikiLink", ""));
        countries.add(new Country(2, "NL", "NETHERLANDS", "continent", "wikiLink", ""));
        countries.add(new Country(3, "BG", "BELGIUM", "continent", "wikiLink", ""));

        return countries;
    }
}