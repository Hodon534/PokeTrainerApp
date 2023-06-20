package com.webapp.poketrainer.model.constants;

/**
 * Constants that represents exception messages
 */
public class ExceptionConst {
    private ExceptionConst(){}
    public static final String USER_NOT_FOUND_MESSAGE = "User with email %s had not been found.";
    public static final String EMAIL_ALREADY_TAKEN_MESSAGE = "Email %s already taken.";
    public static final String TOKEN_EXPIRED_MESSAGE = "Token has already expired!";
    public static final String EMAIL_ALREADY_CONFIRMED_MESSAGE = "Email has been already confirmed.";
    public static final String TOKEN_NOT_FOUND_MESSAGE = "Token hasn't been found.";
    public static final String TRAINER_DOES_NOT_EXIST_MESSAGE = "Trainer with that ID doesn't exist.";
    public static final String CARDS_NOT_FOUND_EXCEPTION = "You have no cards in possession.";
    public static final String CARD_NOT_FOUND_EXCEPTION = "Card with id %s doesn't exist in database";
    public static final String POKEMON_NOT_FOUND_EXCEPTION = "Pokemon with id %s doesn't exist in database";
    public static final String USER_NOT_FOUND_EXCEPTION = "User with id %s doesn't exist in database";
}
