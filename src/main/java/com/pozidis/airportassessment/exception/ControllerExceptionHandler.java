package com.pozidis.airportassessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author arist
 */

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ElementNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleElementNotFoundException(ElementNotFoundException exception) {
        return new ErrorMessage(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleBadRequestException(BadRequestException exception) {
        return new ErrorMessage(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
