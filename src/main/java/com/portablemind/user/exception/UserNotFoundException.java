package com.portablemind.user.exception;

/**
 * Created by Mateusz on 30.09.2015.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
