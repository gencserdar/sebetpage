package com.serdar.personal.exception;

public class EmailAlreadyUsedException extends RuntimeException {
    public EmailAlreadyUsedException() {
        super("Email already in use");
    }

    public EmailAlreadyUsedException(String message) {
        super(message);
    }
}
