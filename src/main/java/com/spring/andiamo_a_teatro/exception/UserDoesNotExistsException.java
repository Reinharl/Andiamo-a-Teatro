package com.spring.andiamo_a_teatro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserDoesNotExistsException extends Exception {
    public UserDoesNotExistsException() {
        super();
    }
}
