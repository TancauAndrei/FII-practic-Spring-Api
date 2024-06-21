package com.eduard.fiiproject.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException() {
        super("User not found");
        setStackTrace(new StackTraceElement[]{});
    }
    public UserNotFoundException(String message) {
        super(message);
        setStackTrace(new StackTraceElement[]{});
    }
}
