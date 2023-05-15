package com.webapp.poketrainer.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.poketrainer.model.pojo.Pokemon;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsonParserService {
    private final ObjectMapper objectMapper;

    public JsonParserService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Pokemon parseJsonToObject(String input) throws IOException {
        return objectMapper.readValue(input, Pokemon.class);
    }
}
