package com.webapp.poketrainer.exception;

public class CardsNotFoundException extends RuntimeException {

    public CardsNotFoundException(String message) {
        super(message);
    }
}
