package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.PokemonEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PokemonRepositoryTest {

    @Autowired
    private PokemonRepository underTest;

    @Test
    void shouldFindPokemonById() {
        //given
        Long id = 33L;
        String name = "nidorino";
        List<String> types = new ArrayList<>(
                Arrays.asList(
                        "Poison"
                ));
        PokemonEntity pokemonInput = new PokemonEntity(
                id,
                name,
                9L,
                195L,
                types,
                128L,
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/33.svg"
        );
        //when
        underTest.save(pokemonInput);
        Optional<PokemonEntity> optionalPokemon = underTest.findPokemonById(id);
        //then
        assertTrue(optionalPokemon.isPresent());
    }

    @Test
    void shouldNotFindPokemonById() {
        //given
        Long id = 89L;
        //when
        //then
        Optional<PokemonEntity> optionalPokemon = underTest.findPokemonById(id);
        assertFalse(optionalPokemon.isPresent());
    }

}