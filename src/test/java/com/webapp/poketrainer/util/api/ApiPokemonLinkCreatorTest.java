package com.webapp.poketrainer.util.api;

import com.webapp.poketrainer.util.api.interfaces.ApiLinkCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiPokemonLinkCreatorTest {

    @Test
    void createLink() {
        //given
        ApiLinkCreator apiPokemonLinkCreator = new ApiPokemonLinkCreator();
        //when
        String properUrl = "https://pokeapi.co/api/v2/pokemon/123";
        int input = 123;
        //then
        assertEquals(properUrl, apiPokemonLinkCreator.createLink(input));
    }
}