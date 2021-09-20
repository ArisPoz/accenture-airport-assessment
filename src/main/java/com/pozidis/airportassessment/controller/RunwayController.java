package com.pozidis.airportassessment.controller;

import com.pozidis.airportassessment.domain.Runway;
import com.pozidis.airportassessment.service.RunwayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author arist
 */

@RestController
public class RunwayController {

    private final RunwayService runwayService;

    public RunwayController(RunwayService runwayService) {
        this.runwayService = runwayService;
    }

    @GetMapping("/runwaysByCountryName")
    public List<Runway> getRunwaysByCountryName(@RequestParam String name) {
        return runwayService.getRunwaysByCountryName(name);
    }

    @GetMapping("/runwaysByCountryCode")
    public List<Runway> getRunwaysByCountryCode(@RequestParam String code) {
        return runwayService.getRunwaysByCountryCode(code);
    }
}