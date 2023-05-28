package com.webapp.poketrainer.service;

import com.webapp.poketrainer.mapper.PokemonMapper;
import com.webapp.poketrainer.model.dto.PokemonDto;
import com.webapp.poketrainer.model.entity.PokemonEntity;
import com.webapp.poketrainer.model.pojo.pokemon.Pokemon;
import com.webapp.poketrainer.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;

    public PokemonService(PokemonRepository pokemonRepository, PokemonMapper pokemonMapper) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;
    }

    public PokemonEntity addPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemonMapper.pokemonPojoToPokemonEntity(pokemon));
    }

    public List<PokemonDto> findAllPokemons() {
        List<PokemonEntity> pokemonEntitiesList = pokemonRepository.findAll();
        List<PokemonDto> pokemonDtoList = pokemonEntitiesList.stream().map(pokemonMapper::pokemonEntityToPokemonDto).toList();
        return pokemonDtoList;
    }

}
