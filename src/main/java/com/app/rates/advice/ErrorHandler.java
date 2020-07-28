package com.app.rates.advice;

import com.app.rates.exception.InvalidDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<Object> handleValidationException(Exception ex) {

        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
