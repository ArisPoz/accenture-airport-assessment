package com.pozidis.airportassessment.service.impl;

import com.pozidis.airportassessment.domain.Country;
import com.pozidis.airportassessment.repository.CountryRepository;
import com.pozidis.airportassessment.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author arist
 */

@SpringBootTest
@RunWith(SpringRunner.class)
class CountryServiceIT {

    @Autowired
    private CountryService countryService;

    @MockBean
    private CountryRepository countryRepository;

    @BeforeEach
    void setUp() {
        int topNumberOfCountries = 3;

        Mockito.when(countryRepository
                .getTopCountriesByNumberOfAirports(topNumberOfCountries))
                .thenReturn(getCountries());
    }


    @Test
    void getTopCountriesByNumberOfAirportsTest() {
        // given
        int numberOfTopCountries = 3;

        // when
        List<Country> countries = countryService.getTopCountriesByNumberOfAirports(numberOfTopCountries);

        // then
        assertThat(countries).isNotEmpty();
    }

    private List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country(1, "GR", "GREECE", "continent", "wikiLink", ""));
        countries.add(new Country(2, "NL", "NETHERLANDS", "continent", "wikiLink", ""));
        countries.add(new Country(3, "BG", "BELGIUM", "continent", "wikiLink", ""));

        return countries;
    }
}