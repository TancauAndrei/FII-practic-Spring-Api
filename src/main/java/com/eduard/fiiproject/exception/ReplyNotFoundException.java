package com.eduard.fiiproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReplyNotFoundException extends RuntimeException {
    public ReplyNotFoundException(String s) {
        super(s);
        setStackTrace(new StackTraceElement[]{});
    }
}
