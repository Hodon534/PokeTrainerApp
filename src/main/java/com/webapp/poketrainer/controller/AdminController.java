package com.webapp.poketrainer.controller;

import com.webapp.poketrainer.model.entity.PokemonEntity;
import com.webapp.poketrainer.model.pojo.Pokemon;
import com.webapp.poketrainer.service.JsonParserService;
import com.webapp.poketrainer.service.PokemonService;
import com.webapp.poketrainer.util.api.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class AdminController {

    private final JsonParserService jsonParserService;

    private final PokemonService pokemonService;

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/addAllPokemon")
    public ResponseEntity<String> addAllPokemons() throws IOException {
        //List<Pokemon> pokemonList = new ArrayList<>();
        for (int i = 2; i <= 2; i++) {
            //pokemonList.add(jsonParserService.parseJsonToObject(ApiService.requestData(i)));
            addCard(jsonParserService.parseJsonToObject(ApiService.requestData(i)));
        }

        return new ResponseEntity<>("All Pokemons had been added to DB.", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PokemonEntity> addCard(@RequestBody Pokemon pokemon) {
        PokemonEntity newCard = pokemonService.addPokemon(pokemon);
        return new ResponseEntity<>(newCard, HttpStatus.OK);
    }
}
