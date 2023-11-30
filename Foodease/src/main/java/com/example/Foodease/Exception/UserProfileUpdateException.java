package com.example.Foodease.Exception;

import org.springframework.http.HttpStatus;

public class UserProfileUpdateException extends RuntimeException{
    public UserProfileUpdateException( String message) {
        super(message);
        }

    public UserProfileUpdateException(HttpStatus httpStatus, String errorupdating) {
    }

    public UserProfileUpdateException(HttpStatus httpStatus, String s, Exception e) {
    }
}
