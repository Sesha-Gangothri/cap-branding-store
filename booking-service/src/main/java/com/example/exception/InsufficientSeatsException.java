package com.example.exception;

public class InsufficientSeatsException extends RuntimeException {
    public InsufficientSeatsException(String message) {

        super(message);
    }
}
