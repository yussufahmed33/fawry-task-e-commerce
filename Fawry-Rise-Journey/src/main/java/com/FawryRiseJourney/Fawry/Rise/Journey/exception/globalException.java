package com.FawryRiseJourney.Fawry.Rise.Journey.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalException {
@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validException(MethodArgumentNotValidException e) {
    String error = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
}
}
