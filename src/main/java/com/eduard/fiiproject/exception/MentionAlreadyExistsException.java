package com.eduard.fiiproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class MentionAlreadyExistsException extends RuntimeException {
    public MentionAlreadyExistsException(String s) {
        super(s);
        setStackTrace(new StackTraceElement[0]);
    }
}
