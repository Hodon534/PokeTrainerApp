package com.webapp.poketrainer.service;

import com.webapp.poketrainer.exception.CardException;
import com.webapp.poketrainer.mapper.PokemonMapper;
import com.webapp.poketrainer.model.constants.ExceptionConst;
import com.webapp.poketrainer.model.dto.PokemonDto;
import com.webapp.poketrainer.model.entity.PokemonEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.enums.PokemonGeneration;
import com.webapp.poketrainer.model.pojo.pokemon.Pokemon;
import com.webapp.poketrainer.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * Service responsible for handling Pokemon Database queries
 */
@Service
@Transactional
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;
    private static final Random random = new Random();
    public PokemonService(PokemonRepository pokemonRepository, PokemonMapper pokemonMapper) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;
    }

    //TODO?
    public PokemonEntity add(Pokemon pokemon) {
        return pokemonRepository
                .save(pokemonMapper.pojoToEntity(pokemon));
    }

    public PokemonEntity get(Long id) {
        return pokemonRepository.findById(id).orElseThrow(
                () -> new CardException(String.format(ExceptionConst.POKEMON_NOT_FOUND_EXCEPTION, id))
        );
    }

    public boolean exist(Long id) {
        return pokemonRepository.existsById(id);
    }

    public PokemonEntity update(PokemonEntity pokemonEntity) {
        return pokemonRepository.save(pokemonEntity);
    }

    public List<PokemonDto> findAll() {
        List<PokemonEntity> pokemonEntitiesList = pokemonRepository.findAll();
        return pokemonEntitiesList.stream().map(pokemonMapper::entityToDto).toList();
    }

    public PokemonEntity catchRandom(TrainerEntity trainerEntity) {
        int randomNo;
        while (true) {
            randomNo = random.nextInt(PokemonGeneration.ALL.indexStart, PokemonGeneration.ALL.indexEnd);
            if (exist((long) randomNo) && !get((long) randomNo).getTrainers().contains(trainerEntity)) {
                break;
            }
        }
        return get((long) randomNo);
    }
}
