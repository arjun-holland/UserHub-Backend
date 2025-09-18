package com.arjun.fullstack_backend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not found the user with id "+ id);
    }
}

// A custom exception that you throw when a user is not found: