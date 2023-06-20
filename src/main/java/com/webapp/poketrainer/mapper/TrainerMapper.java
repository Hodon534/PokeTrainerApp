package com.webapp.poketrainer.mapper;

import com.webapp.poketrainer.model.dto.TrainerDto;
import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.entity.PokemonEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.service.CardService;
import com.webapp.poketrainer.service.PokemonService;
import com.webapp.poketrainer.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TrainerMapper {
    private final CardService cardService;
    private final PokemonService pokemonService;
    private final UserService userService;

    public TrainerDto entityToDto(TrainerEntity trainerEntity) {
        Map<String, Integer> cards = new HashMap<>();
        trainerEntity.getCards().forEach((key, value) -> cards.put(key.getId(), value));
        return new TrainerDto(
                trainerEntity.getId(),
                trainerEntity.getName(),
                cards,
                trainerEntity.getPokemons().stream().map(PokemonEntity::getId).collect(Collectors.toSet()),
                trainerEntity.getTrainerType(),
                trainerEntity.getUser().getId()
        );
    }

    public TrainerEntity dtoToEntity(TrainerDto trainerDto) {
        Map<CardEntity, Integer> cards = new HashMap<>();
        trainerDto.getCards().forEach((key, value) -> cards.put(cardService.get(key), value));
        return new TrainerEntity(
                trainerDto.getId(),
                trainerDto.getName(),
                cards,
                trainerDto.getPokemons().stream().map(pokemonService::get).collect(Collectors.toSet()),
                trainerDto.getTrainerType(),
                userService.get(trainerDto.getUser())
        );
    }
}
