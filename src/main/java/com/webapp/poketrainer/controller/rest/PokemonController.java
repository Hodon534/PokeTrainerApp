package com.webapp.poketrainer.controller.rest;

import com.webapp.poketrainer.mapper.PokemonMapper;
import com.webapp.poketrainer.model.entity.PokemonEntity;
import com.webapp.poketrainer.model.enums.PokemonGeneration;
import com.webapp.poketrainer.model.pojo.pokemon.Pokemon;
import com.webapp.poketrainer.service.PokemonService;
import com.webapp.poketrainer.util.api.ApiPokemonLinkCreator;
import com.webapp.poketrainer.util.api.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;
    private final ApiService apiService;
    private final ApiPokemonLinkCreator apiPokemonLinkCreator;
    private final PokemonMapper pokemonMapper;

    @GetMapping("/addPokemonById")
    public ResponseEntity<String> addAllPokemons(@RequestParam("id") String id) throws IOException {
        addCard(pokemonMapper.mapJsonToPokemon(
                apiService.requestData(
                        id)));

        return new ResponseEntity<>("Pokemon has been added to DB.", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PokemonEntity> addCard(@RequestBody Pokemon pokemon) {
        PokemonEntity newCard = pokemonService.addPokemon(pokemon);
        return new ResponseEntity<>(newCard, HttpStatus.OK);
    }


    @GetMapping("/update")
    public String update(@RequestParam("pokemonGeneration") String gen) throws IOException {
        System.out.println("omg");
        for (int i = PokemonGeneration.valueOf(gen).indexStart; i <= PokemonGeneration.valueOf(gen).indexEnd; i++) {
            addCard(pokemonMapper.mapJsonToPokemon(
                    apiService.requestData(
                            apiPokemonLinkCreator.createLink(
                                    i))));
        }
        return "admin";
    }

    @PostMapping("/catchRandom")
    public void getRandomPokemon() throws IOException {
        //pokemonService.addTrainerToPokemon();
    }
}
