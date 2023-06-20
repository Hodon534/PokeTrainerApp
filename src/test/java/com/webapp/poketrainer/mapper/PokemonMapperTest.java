package com.webapp.poketrainer.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.poketrainer.model.dto.PokemonDto;
import com.webapp.poketrainer.model.entity.PokemonEntity;
import com.webapp.poketrainer.model.pojo.pokemon.*;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokemonMapperTest {
/*
    @Autowired
    private static PokemonMapper underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = new PokemonMapper(new ObjectMapper());
    }

    @Test
    void pojoToEntity() {
        // given
        List<String> listOfTypes = List.of("poison", "grass");
        Type poison = new Type();
        poison.setType(new Species());
        poison.getType().setName(listOfTypes.get(0));
        Type grass = new Type();
        grass.setType(new Species());
        grass.getType().setName(listOfTypes.get(1));
        Type[] types = {poison, grass};
        Pokemon pokemon = new Pokemon();
        pokemon.setSprites(new Sprites());
        pokemon.getSprites().setOther(new Other());
        pokemon.getSprites().getOther().setDreamWorld(new DreamWorld());
        pokemon.setId(1);
        pokemon.setName("bulbasaur");
        pokemon.setHeight(7);
        pokemon.setWeight(69);
        pokemon.setTypes(types);
        pokemon.setBaseExperience(64);
        pokemon.getSprites().getOther().getDreamWorld().setFrontDefault("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/1.svg");
        // when
        PokemonEntity pokemonEntity = underTest.pojoToEntity(pokemon);
        // then
        assertAll(
                () -> assertEquals(pokemonEntity.getId(), pokemon.getId()),
                () -> assertEquals(pokemonEntity.getName(), pokemon.getName()),
                () -> assertEquals(pokemonEntity.getHeight(), pokemon.getHeight()),
                () -> assertEquals(pokemonEntity.getWeight(), pokemon.getWeight()),
                () -> assertEquals(pokemonEntity.getPokemonTypes(), listOfTypes),
                () -> assertEquals(pokemonEntity.getBaseExperience(), pokemon.getBaseExperience()),
                () -> assertEquals(pokemonEntity.getBigImage(), pokemon.getSprites().getOther().getDreamWorld().getFrontDefault())
        );
    }*/

    /*@Test
    void entityToDto() {
        // given
        PokemonEntity pokemonEntity = new PokemonEntity(
                1L,
                "bulbasaur",
                7L,
                69L,
                List.of("poison", "grass"),
                64L,
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/1.svg"
        );
        // when
        PokemonDto pokemonDto = underTest.entityToDto(pokemonEntity);
        // then
        assertAll(
                () -> assertEquals(pokemonDto.getId(), pokemonEntity.getId()),
                () -> assertEquals(pokemonDto.getName(), pokemonEntity.getName()),
                () -> assertEquals(pokemonDto.getHeight(), pokemonEntity.getHeight()),
                () -> assertEquals(pokemonDto.getWeight(), pokemonEntity.getWeight()),
                () -> assertEquals(pokemonDto.getTypes(), pokemonEntity.getPokemonTypes()),
                () -> assertEquals(pokemonDto.getBaseExperience(), pokemonEntity.getBaseExperience()),
                () -> assertEquals(pokemonDto.getBigImage(), pokemonEntity.getBigImage())
        );
    }*/

    @Test
    void mapJsonToPokemon() {
    }
}