package com.spring.andiamo_a_teatro.exception;

public class NonExistentShowException extends Exception {
    public NonExistentShowException(String message) {
        super(message);
    }
}
