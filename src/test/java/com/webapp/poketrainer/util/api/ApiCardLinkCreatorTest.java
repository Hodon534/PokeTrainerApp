package com.webapp.poketrainer.util.api;

import com.webapp.poketrainer.util.api.interfaces.ApiLinkCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiCardLinkCreatorTest {


    @Test
    void createLink() {
        //given
        ApiLinkCreator apiCardLinkCreator = new ApiCardLinkCreator();
        //when
        String properUrl = "https://api.pokemontcg.io/v2/cards?page=2618&pageSize=1";
        int input = 2618;
        //then
        assertEquals(properUrl, apiCardLinkCreator.createLink(input));
    }
}