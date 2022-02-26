package com.delly.delly.exception.exceptions;

public class OrdersNotFoundException extends RuntimeException{
    public OrdersNotFoundException(String userWithID) {
        super("Orders haven't been found for " + userWithID);
    }
}
