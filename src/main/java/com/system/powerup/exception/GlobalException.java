package com.system.powerup.exception;

import com.system.powerup.exception.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationError(MethodArgumentNotValidException ex) {

        ApiError response = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                "Validation failed"
        );
        return ResponseEntity.badRequest().body(response);
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
    public ResponseEntity<ApiError> handleGeneralException(Exception ex, HttpServletRequest request) {

        String path = request.getRequestURI();

        // Let Swagger handle its own documentation exceptions
        if (path.contains("/swagger") || path.contains("/v3/api-docs") || path.contains("/api-docs")) {
            return null; // Let Spring/Springdoc handle
        }

        ApiError response = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error"
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
