package com.example.backendfight.exceptionHandlers;

import com.example.backendfight.exceptions.AppInvalidRequestException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(AppInvalidRequestException.class)
    public ResponseEntity<Map<String, Object>> handleAppInvalidRequestException(AppInvalidRequestException exception) {
    Map<String, Object> errors = new HashMap<>();
        errors.put("message", exception.getMessage());

        return ResponseEntity.status(exception.getStatus()).body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException exception) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("message", exception.getMessage());

        return ResponseEntity.status(422).body(errors);
    }
}
