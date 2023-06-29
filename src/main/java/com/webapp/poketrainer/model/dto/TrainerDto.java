package com.webapp.poketrainer.model.dto;

import com.webapp.poketrainer.model.enums.TrainerType;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

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

    public int getCountOfCards() {
        AtomicInteger sum = new AtomicInteger();
        cards.forEach((key, value) -> sum.addAndGet(value));
        return sum.intValue();
    }

    public int getCountOfPokemons() {
        return pokemons.size();
    }
}
