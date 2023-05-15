package com.webapp.poketrainer.util.api;

import com.webapp.poketrainer.model.enums.PokeDexType;

import java.util.Random;

public class ApiLinkCreator {
    private final String BASE_LINK = "https://pokeapi.co/api/v2/";

    private final Random random;

    public ApiLinkCreator() {
        this.random = new Random();
    }

    public String createLink(int value) {
        return BASE_LINK
                + getKey()
                + String.valueOf(value);
    }

    private String getKey() {
        return ApiSettings.POKEMON.key + "/" ;
    }

/*    private String getValue(int value) {
        //return String.valueOf(PokeDexType.I_GEN.numberOfEntries);
        return String.valueOf(value);
    }*/

}
