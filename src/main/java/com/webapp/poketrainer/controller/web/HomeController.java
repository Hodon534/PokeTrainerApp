package com.webapp.poketrainer.controller.web;

import com.webapp.poketrainer.model.pojo.pokemon.Pokemon;
import com.webapp.poketrainer.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Home Page
 */
@AllArgsConstructor
@Controller
public class HomeController {

    private final PokemonService pokemonService;

    /**
     * Method responsible for redirecting to home page
     * @return index (index.html)
     */
    @GetMapping({"/", "/index", "/home"})
    public String getPage(Model model) {
        model.addAttribute("pokemon", pokemonService.getRandom());
        return "index";
    }


}
