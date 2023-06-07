package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.ModelPage;
import com.webapp.poketrainer.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Pokedex Page
 */
@AllArgsConstructor
@Controller
public class PokedexController implements ModelPage {

    private final PokemonService pokemonService;

    /**
     * Method responsible for redirecting to pokedex page
     * @param model - All pokemons available in database
     * @return pokedex (pokedex.html)
     */
    @Override
    @GetMapping("/pokedex")
    public String getPage(Model model) {
        model.addAttribute("pokemons", pokemonService.findAllPokemons());
        return "pokedex";
    }
}
