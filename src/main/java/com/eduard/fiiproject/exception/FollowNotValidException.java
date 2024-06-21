package com.eduard.fiiproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FollowNotValidException extends RuntimeException {
    public FollowNotValidException(String s) {
        super(s);
        setStackTrace(new StackTraceElement[0]);
    }
}
