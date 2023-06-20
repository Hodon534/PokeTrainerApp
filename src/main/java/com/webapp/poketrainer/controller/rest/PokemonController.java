package com.webapp.poketrainer.controller.rest;

import com.webapp.poketrainer.mapper.PokemonMapper;
import com.webapp.poketrainer.model.constants.LogConst;
import com.webapp.poketrainer.model.enums.PokemonGeneration;
import com.webapp.poketrainer.model.pojo.pokemon.Pokemon;
import com.webapp.poketrainer.service.PokemonService;
import com.webapp.poketrainer.service.TrainerService;
import com.webapp.poketrainer.util.api.ApiPokemonLinkCreator;
import com.webapp.poketrainer.util.api.ApiService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/pokemon")
@Slf4j
public class PokemonController {
    private final PokemonService pokemonService;
    private final ApiService apiService;
    private final ApiPokemonLinkCreator apiPokemonLinkCreator;
    private final PokemonMapper pokemonMapper;
    private final TrainerService trainerService;


    @PostMapping("/add")
    public void addPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.add(pokemon);
    }


    @GetMapping("/update")
    public String update(@RequestParam("pokemonGeneration") String gen) throws IOException {
        for (int i = PokemonGeneration.valueOf(gen).indexStart; i <= PokemonGeneration.valueOf(gen).indexEnd; i++) {
            addPokemon(pokemonMapper.mapJsonToPokemon(
                    apiService.requestData(
                            apiPokemonLinkCreator.createLink(
                                    i))));
        }
        log.info(LogConst.POKEMON_ALL_ADDED_SUCCESSFULLY);
        return "admin";
    }

    @PostMapping("/catchRandom")
    public void getRandomPokemon() {
        trainerService
                .addPokemon(pokemonService.catchRandom(trainerService.getLogged()));
    }
}
