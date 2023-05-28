package com.webapp.poketrainer.model.constants;

/**
 * Constants related to Api Requests that are being sent to external databases
 */
public class ApiConst {

    /**
     * pokeapi.co base link
     */
    public final static String POKEMON_API_BASE_LINK = "https://pokeapi.co/api/v2/";
    public final static String POKEMON_API_POKEMON_TEXT = "pokemon";
    /**
     * api.pokemontcg.io base link
     */
    public final static String CARD_API_BASE_LINK = "https://api.pokemontcg.io/v2/cards";
    public final static String CARD_API_PAGE_TEXT = "page";
    public final static int CARD_API_PAGE_VALUE = 16125;
    public final static String CARD_API_PAGE_SIZE_TEXT = "pageSize";
    public final static int CARD_API_PAGE_SIZE_VALUE = 1;
    public final static int CARD_NUMBER_OF_FREE_CARDS = 5;

    public final static String SIGN_SLASH = "/";
    public final static String SIGN_EQUALS = "=";
    public final static String SIGN_AND = "&";
    public final static String SIGN_QUESTION_MARK = "?";
}
