package com.webapp.poketrainer.controller.rest;

import com.webapp.poketrainer.service.CardService;
import com.webapp.poketrainer.service.TrainerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/cards")
public class CardController {

    private final CardService cardService;
    private final TrainerService trainerService;

    public CardController(CardService cardService, TrainerService trainerService) {
        this.cardService = cardService;
        this.trainerService = trainerService;
    }


    /**
     * Get 5 random cards
     * @return
     */
    @PostMapping("/getRandom")
    public void getRandomCards() throws IOException {
        trainerService.addCards(cardService.getRandomCards());
    }
}
