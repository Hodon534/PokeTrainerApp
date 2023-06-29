package com.webapp.poketrainer.model.constants;

/**
 * Constants related to Api Requests that are being sent to external databases
 */
public class ApiConst {

    private ApiConst(){}
    /**
     * Pokemons Database
     * pokeapi.co base link
     */
    public static final String POKEMON_API_BASE_LINK = "https://pokeapi.co/api/v2/";
    public static final String POKEMON_API_POKEMON_TEXT = "pokemon";
    public static final String POKEMON_API_GENDER_TEXT = "gender";
    public static final String POKEMON_API_EVOLUTION_TEXT = "evolution-chain";
    public static final String POKEMON_API_CHARACTERISTIC_TEXT = "characteristic";
    /**
     * Pokemon Cards Database
     * api.pokemontcg.io base link
     */
    public static final String CARD_API_BASE_LINK = "https://api.pokemontcg.io/v2/cards";
    public static final String CARD_API_PAGE_TEXT = "page";
    public static final int CARD_API_PAGE_VALUE = 16125;
    public static final String CARD_API_PAGE_SIZE_TEXT = "pageSize";
    public static final int CARD_API_PAGE_SIZE_VALUE = 1;
    public static final int CARD_NUMBER_OF_FREE_CARDS = 5;
    /**
     * Signs that are being used while creating urls for API requests
     */
    public static final String SIGN_SLASH = "/";
    public static final String SIGN_EQUALS = "=";
    public static final String SIGN_AND = "&";
    public static final String SIGN_QUESTION_MARK = "?";
}
