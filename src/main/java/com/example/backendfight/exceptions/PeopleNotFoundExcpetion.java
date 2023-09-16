package com.example.backendfight.exceptions;

import org.springframework.http.HttpStatus;

public class PeopleNotFoundExcpetion extends  AppException{
    public PeopleNotFoundExcpetion(String message, Integer status) {
        super(message, status);
    }
}
