package com.example.Foodease.Exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(HttpStatus httpStatus, String incorrectPassword) {
    }
}
