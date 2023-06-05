package com.webapp.poketrainer.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.poketrainer.model.dto.PokemonDto;
import com.webapp.poketrainer.model.entity.PokemonEntity;
import com.webapp.poketrainer.model.pojo.pokemon.Pokemon;
import com.webapp.poketrainer.model.pojo.pokemon.Type;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                getTypesFromPojo(pokemon),
                pokemon.getBaseExperience(),
                pokemon.getSprites().getOther().getDreamWorld().getFrontDefault());
    }

    /**
     * Extract pokemon types and return 'em as a list
     */
    private List<String> getTypesFromPojo(Pokemon pokemon) {
        List<String> types = new ArrayList<>();
        for (Type type : pokemon.getTypes()) {
            types.add(type.getType().getName());
        }
        return types;
    }

    /**
     * Map PokemonEntity to Pokemon Dto
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
                pokemonEntity.getBigImage());
    }

    public PokemonEntity dtoToEntity(PokemonDto pokemonDto) {
        return new PokemonEntity(
                pokemonDto.getId(),
                pokemonDto.getName(),
                pokemonDto.getHeight(),
                pokemonDto.getWeight(),
                pokemonDto.getTypes(),
                pokemonDto.getBaseExperience(),
                pokemonDto.getBigImage()
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
