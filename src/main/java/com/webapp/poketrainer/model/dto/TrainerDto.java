package com.webapp.poketrainer.model.dto;

import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.model.enums.TrainerType;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;

@Data
@AllArgsConstructor
public class TrainerDto {
    private Long id;
    private String name;
    private List<CardDto> cards;
    private List<PokemonDto> pokemons;
    private TrainerType trainerType;
    private UserEntity userEntity;

}
