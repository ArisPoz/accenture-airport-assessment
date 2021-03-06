package com.pozidis.airportassessment.controller;

import com.pozidis.airportassessment.domain.Runway;
import com.pozidis.airportassessment.service.RunwayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author arist
 */

@RestController
@RequestMapping("/v1/runways")
public class RunwayController {
    private final RunwayService runwayService;

    public RunwayController(RunwayService runwayService) {
        this.runwayService = runwayService;
    }

    @GetMapping(value = "country-name", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Runway> getRunwaysByCountryName(@RequestParam String name) {
        return runwayService.getRunwaysByCountryName(name);
    }

    @GetMapping(value = "country-code", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Runway> getRunwaysByCountryCode(@RequestParam String code) {
        return runwayService.getRunwaysByCountryCode(code);
    }
}