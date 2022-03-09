package com.delly.delly.exception.exceptions;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String ID) {
        super("User already exists with email: " + ID);
    }
}
