package com.webapp.poketrainer.util.api;

import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;

@AllArgsConstructor
class ApiServiceTest {

    @Autowired
    private final ApiService underTest = new ApiService(WebClient.builder().build());

    @Test
    void requestPokemonCardsData() throws JSONException {
        // given
        String url = "https://api.pokemontcg.io/v2/cards?page=2618&pageSize=1";
        String jsonArrayName = "data";
        int i = 0;
        // when
        String response = underTest.requestData(url);
        JSONObject jsonObject = new JSONObject(response);
        JSONArray basicData = jsonObject.getJSONArray(jsonArrayName);
        String expectedId = "ex5-19";
        String responseId = basicData.getJSONObject(i).getString("id");
        String expectedName = "Huntail";
        String responseName = basicData.getJSONObject(i).getString("name");
        String expectedSmallImage = "https://images.pokemontcg.io/ex5/19.png";
        String responseSmallImage = basicData.getJSONObject(i).getJSONObject("images").getString("small");
        // then
        assertAll(
                () -> assertEquals(expectedId, responseId),
                () -> assertEquals(expectedName, responseName),
                () -> assertEquals(expectedSmallImage, responseSmallImage)
        );
    }

    @Test
    void requestPokemonData() throws JSONException {
        // given
        String url = "https://pokeapi.co/api/v2/pokemon/1";
        // when
        String response = underTest.requestData(url);
        JSONObject jsonObject = new JSONObject(response);
        long expectedId = 1L;
        long responseId = jsonObject.getLong("id");
        String expectedName = "bulbasaur";
        String responseName = jsonObject.getString("name");
        long expectedHeight = 7L;
        long responseHeight = jsonObject.getLong("height");
        long expectedWeight = 69L;
        long responseWeight = jsonObject.getLong("weight");
        long expectedBaseExperience = 64L;
        long responseBaseExperience = jsonObject.getLong("base_experience");
        String expectedBigImage = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/1.svg";
        String responseBigImage = jsonObject
                .getJSONObject("sprites")
                .getJSONObject("other")
                .getJSONObject("dream_world")
                .getString("front_default");
        // then
        assertAll(
                () -> assertEquals(expectedId, responseId),
                () -> assertEquals(expectedName, responseName),
                () -> assertEquals(expectedHeight, responseHeight),
                () -> assertEquals(expectedWeight, responseWeight),
                () -> assertEquals(expectedBaseExperience, responseBaseExperience),
                () -> assertEquals(expectedBigImage, responseBigImage)
        );
    }
}