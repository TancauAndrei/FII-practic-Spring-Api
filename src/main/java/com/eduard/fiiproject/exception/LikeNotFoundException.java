package com.eduard.fiiproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LikeNotFoundException extends RuntimeException {
    public LikeNotFoundException(String s) {
        super(s);
        setStackTrace(new StackTraceElement[0]);
    }
}
