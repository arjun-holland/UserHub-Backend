package com.arjun.fullstack_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
// Handles exceptions globally
//🔍 What it does:
//Tells Spring: “Hey, if any controller throws an exception, check here first to see
//if there’s a handler for it.”
//Used to centralize error handling instead of repeating code in every controller

public class UserNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(UserNotFoundException exception){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());
        return errorMap;
    }
}

/*
This is a global exception handler that catches the UserNotFoundException
and returns a custom error response instead of letting Spring Boot return a generic error page.

| Part                    | Role                                                                                  |
| ----------------------- | ------------------------------------------------------------------------------------- |
| `UserNotFoundException` | Custom exception to signal a missing user                                             |
| `UserNotFoundAdvice`    | Catches that exception and builds a friendly JSON response                            |
| `@ControllerAdvice`     | Makes the handler global — applies to all controllers                                 |
| Result                  | Better API errors (e.g. `{ "errorMessage": "Could not found the user with id 999" }`) |

* */