package com.webapp.poketrainer.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.poketrainer.model.dto.PokemonDto;
import com.webapp.poketrainer.model.entity.PokemonEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.pojo.pokemon.Pokemon;
import com.webapp.poketrainer.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Pokemon Mapper:
 * String -> Pokemon
 * Pokemon -> PokemonEntity
 * PokemonEntity -> PokemonDto
 */
@AllArgsConstructor
@Component
public class PokemonMapper {
    private final ObjectMapper objectMapper;
    private final TrainerService trainerService;

    /**
     * Map Pokemon Pojo To Entity in DB
     * @param pokemon - pokemon POJO from api request
     * @return PokemonEntity - Object in DB
     */
    public PokemonEntity pojoToEntity(Pokemon pokemon) {
        return new PokemonEntity(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                Arrays.stream(pokemon.getTypes()).map(value -> value.getType().getName()).toList(),
                pokemon.getBaseExperience(),
                pokemon.getSprites().getOther().getDreamWorld().getFrontDefault(),
                new HashSet<>());
    }

    /**
     * Map PokemonEntity to PokemonDto
     * @param pokemonEntity - entity from DB
     * @return PokemonDto - Object of Pokemon
     */
    public PokemonDto entityToDto(PokemonEntity pokemonEntity) {
        return new PokemonDto(
                pokemonEntity.getId(),
                pokemonEntity.getName(),
                pokemonEntity.getHeight(),
                pokemonEntity.getWeight(),
                pokemonEntity.getPokemonTypes(),
                pokemonEntity.getBaseExperience(),
                pokemonEntity.getBigImage(),
                pokemonEntity.getTrainers().stream().map(TrainerEntity::getId).collect(Collectors.toSet()));
    }

    /**
     * Map PokemonDto to PokemonEntity
     * @param pokemonDto - Object of Pokemon
     * @return PokemonEntity - entity from DB
     */
    public PokemonEntity dtoToEntity(PokemonDto pokemonDto) {
        return new PokemonEntity(
                pokemonDto.getId(),
                pokemonDto.getName(),
                pokemonDto.getHeight(),
                pokemonDto.getWeight(),
                pokemonDto.getTypes(),
                pokemonDto.getBaseExperience(),
                pokemonDto.getBigImage(),
                pokemonDto.getTrainers().stream().map(trainerService::get).collect(Collectors.toSet())
        );
    }


    /**
     * Map Json as String to Pokemon.class
     * @param input - Json as String
     * @return Pokemon Object
     * @throws IOException
     */
    public Pokemon mapJsonToPokemon(String input) throws IOException {
        return objectMapper.readValue(input, Pokemon.class);
    }
}
