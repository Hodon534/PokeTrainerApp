package com.webapp.poketrainer.model.dto;

import lombok.*;

import java.util.List;
import java.util.Set;

//@Data // todo co to za problem
@Getter
@Setter
@EqualsAndHashCode
public class PokemonDto {
    private final long id;
    private final String name;
    private final long height;
    private final long weight;
    private final List<String> types;
    private final long baseExperience;
    private final String bigImage;
    private Set<Long> trainers;
    public PokemonDto(long id, String name, long height, long weight, List<String> types, long baseExperience, String bigImage, Set<Long> trainers) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.types = types;
        this.baseExperience = baseExperience;
        this.bigImage = bigImage;
        this.trainers = trainers;
    }
}
