package com.webapp.poketrainer.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonDto {
    private final long id;
    private final String name;
    private final long height;
    private final long weight;
    private final List<String> types;
    private final long baseExperience;
    private final String bigImage;

    public PokemonDto(long id, String name, long height, long weight, List<String> types, long baseExperience, String bigImage) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.types = types;
        this.baseExperience = baseExperience;
        this.bigImage = bigImage;
    }
}
