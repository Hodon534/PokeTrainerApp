package com.webapp.poketrainer.controller.web;

import com.webapp.poketrainer.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Card Collection Page
 */
@AllArgsConstructor
@Controller
public class CardCollectionController {
    private final TrainerService trainerService;

    /**
     * Method responsible for redirecting to card collection page
     * @return cardCollection (cardCollection.html)
     */
    @GetMapping("/cardCollection")
    public String getPage(Model model) {
        model.addAttribute("cards", trainerService.findAllCardsHeldByLoggedUser());
        return "cardCollection";
    }
}
