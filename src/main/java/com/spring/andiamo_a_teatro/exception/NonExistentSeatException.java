package com.spring.andiamo_a_teatro.exception;

public class NonExistentSeatException extends Exception {
    public NonExistentSeatException(String message) {
        super(message);
    }
}
