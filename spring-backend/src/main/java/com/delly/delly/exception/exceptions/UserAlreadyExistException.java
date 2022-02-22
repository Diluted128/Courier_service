package com.delly.delly.exception.exceptions;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String email) {
        super("User already exists with email: " + email);
    }
}
