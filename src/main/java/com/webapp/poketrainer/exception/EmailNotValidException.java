package com.webapp.poketrainer.exception;

public class EmailNotValidException extends RuntimeException {

    public EmailNotValidException(String message) {
        super(message);
    }
}
