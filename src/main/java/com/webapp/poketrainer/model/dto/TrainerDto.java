package com.webapp.poketrainer.model.dto;

import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.model.enums.TrainerType;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Trainer's Object (DTO):
 *  long - id,
 *  String - name,
 *  Map<String, Integer> - cards,
 *  Set<Long> - pokemons,
 *  TrainerType - trainerType,
 *  long - user id;
 */
@Data
@AllArgsConstructor
public class TrainerDto {
    private long id;
    private String name;
    private Map<String, Integer> cards;
    private Set<Long> pokemons;
    private TrainerType trainerType;
    private long user;
}
