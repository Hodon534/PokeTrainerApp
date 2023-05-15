package com.webapp.poketrainer.service;

import com.webapp.poketrainer.model.entity.PokemonEntity;
import com.webapp.poketrainer.model.pojo.Pokemon;
import com.webapp.poketrainer.model.pojo.Type;
import com.webapp.poketrainer.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonEntity addPokemon(Pokemon pokemon) {
        System.out.println("done");
        System.out.println(pokemon.getSprites().getOther().getFrontDefault());
        PokemonEntity pokemonEntity = new PokemonEntity(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                getTypes(pokemon),
                pokemon.getBaseExperience(),
                pokemon.getSprites().getOther().getFrontDefault());

        return pokemonRepository.save(pokemonEntity);
    }

/*    public PokemonDto addPokemonToDto(Pokemon pokemon) {
        PokemonDto pokemonDto = new PokemonDto(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                getTypes(pokemon),
                pokemon.getBaseExperience(),
                pokemon.getSprites().getOther().getDreamWorld().getFrontDefault());

        return pokemonRepository.save(pokemonEntity);
    }*/

    private List<String> getTypes(Pokemon pokemon) {
        List<String> types = new ArrayList<>();
        for (Type type : pokemon.getTypes()) {
            types.add(type.getType().getName());
            System.out.println(type.getType().getName());
        }
        return types;
    }
}
