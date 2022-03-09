package com.delly.delly.exception.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String email) {
        super("User not found with email: " + email);
    }
}
