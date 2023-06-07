package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.ModelPage;
import com.webapp.poketrainer.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Card Collection Page
 */
@AllArgsConstructor
@Controller
public class CardCollectionController implements ModelPage {

    private final CardService cardService;

    /**
     * Method responsible for redirecting to card collection page
     * @return cardCollection (cardCollection.html)
     */
    @GetMapping("/cardCollection")
    @Override
    public String getPage(Model model) {
        model.addAttribute("cards", cardService.findAllCardsHeldByLoggedTrainer());
        return "cardCollection";
    }
}
