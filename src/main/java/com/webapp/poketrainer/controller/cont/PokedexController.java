package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.ModelPage;
import com.webapp.poketrainer.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class PokedexController implements ModelPage {

    private final PokemonService pokemonService;

    @Override
    @GetMapping("/pokedex")
    public String getPage(Model model) {
        model.addAttribute("pokemons", pokemonService.findAllPokemons());
        return "pokedex";
    }
}
