package com.webapp.poketrainer.controller.rest;

import com.webapp.poketrainer.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    /**
     * Get 5 random cards
     * @return
     */
    @PostMapping("/getRandom")
    public void getRandomCards() throws IOException {
        cardService.addRandomCards();
    }
}
