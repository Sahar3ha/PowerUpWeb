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

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleRuntimeException(RuntimeException ex){
        ApiError response = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request"
        );
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneralErrors(Exception ex){
        ApiError response = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error"
        );

        return  ResponseEntity.badRequest().body(response);
    }
}
