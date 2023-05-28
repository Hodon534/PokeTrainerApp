package com.webapp.poketrainer.model.dto;

import com.webapp.poketrainer.model.enums.PokeBallType;
import com.webapp.poketrainer.model.enums.TrainerType;
import lombok.Data;


import java.util.HashMap;
//todo
@Data
public class TrainerDto {
    private String name;
    private long id;
    private TrainerType trainerType;
    private HashMap<PokemonDto, Integer> ownedPokemons;
    private HashMap<PokeBallType, Integer> ownedPokeBalls;
    private long coins;
}
