package com.system.powerup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError>handleValidationError(MethodArgumentNotValidException ex) {


        ApiError response = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                "Validation failed"

        );
        return  ResponseEntity.badRequest().body(response);
    }
}
