package com.pozidis.airportassessment.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author arist
 */

@Getter
@AllArgsConstructor
public class ErrorMessage {
    private final String message;
    private final int status;
}

