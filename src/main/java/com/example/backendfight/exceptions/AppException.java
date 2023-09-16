package com.example.backendfight.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public abstract class AppException extends Exception {
    private String message;
    private Integer status;
    AppException(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

}
