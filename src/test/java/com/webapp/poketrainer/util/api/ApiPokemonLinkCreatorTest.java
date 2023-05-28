package com.webapp.poketrainer.util.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiPokemonLinkCreatorTest {

    private ApiPokemonLinkCreator apiPokemonLinkCreator;

    @BeforeEach
    void beforeEach() {
        this.apiPokemonLinkCreator = new ApiPokemonLinkCreator();
    }

    @Test
    void createLink() {
        //given
        String expectedUrl = "https://pokeapi.co/api/v2/pokemon/1";
        String pokemonId = "1";
        //when
        //String outputUrl = apiPokemonLinkCreator.createLink(pokemonId);
        //then
        //assertEquals(expectedUrl, outputUrl);
    }
}