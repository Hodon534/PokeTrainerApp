package com.webapp.poketrainer.exception;

public class EmailAlreadyConfirmedException extends RuntimeException {

    public EmailAlreadyConfirmedException(String message) {
        super(message);
    }
}
