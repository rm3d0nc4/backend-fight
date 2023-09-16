package com.example.backendfight.exceptions;


import org.springframework.http.HttpStatus;

public class AppInvalidRequestException extends AppException{
    public AppInvalidRequestException(String message, Integer status) {
        super(message, status);
    }
}
