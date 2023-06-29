package com.webapp.poketrainer.controller.web;

import com.webapp.poketrainer.service.PokemonService;
import com.webapp.poketrainer.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Pokedex Page
 */
@AllArgsConstructor
@Controller
public class PokedexController {

    private final PokemonService pokemonService;

    private final TrainerService trainerService;

    /**
     * Method responsible for redirecting to pokedex page
     * @param model - All pokemons available in database
     * @return pokedex (pokedex.html)
     */
    @GetMapping("/pokedex")
    public String getPage(Model model) {
        model.addAttribute("pokemons", pokemonService.findAll());
        return "pokedex";
    }
}
