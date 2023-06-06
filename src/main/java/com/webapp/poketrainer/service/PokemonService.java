package com.webapp.poketrainer.service;

import com.webapp.poketrainer.mapper.PokemonMapper;
import com.webapp.poketrainer.model.dto.PokemonDto;
import com.webapp.poketrainer.model.entity.PokemonEntity;
import com.webapp.poketrainer.model.pojo.pokemon.Pokemon;
import com.webapp.poketrainer.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service responsible for handling Pokemon Database queries
 */
@Service
@Transactional
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;
    private final TrainerService trainerService;

    public PokemonService(PokemonRepository pokemonRepository, PokemonMapper pokemonMapper, TrainerService trainerService) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;
        this.trainerService = trainerService;
    }

    public PokemonEntity addPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemonMapper.pojoToEntity(pokemon));
    }

    public List<PokemonDto> findAllPokemons() {
        List<PokemonEntity> pokemonEntitiesList = pokemonRepository.findAll();
        List<PokemonDto> pokemonDtoList = pokemonEntitiesList.stream().map(pokemonMapper::entityToDto).toList();
        return pokemonDtoList;
    }

/*    public PokemonEntity addTrainerToPokemon(Long id) {
        if (pokemonRepository.existsById(id)) {

        }
    }*/
}
