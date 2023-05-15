package com.webapp.poketrainer.exception;

public class PokemonNotFoundException extends RuntimeException {

    public PokemonNotFoundException(String message) {
        super(message);
    }
}
