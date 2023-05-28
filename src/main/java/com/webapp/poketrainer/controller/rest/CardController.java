package com.webapp.poketrainer.controller.rest;

import com.webapp.poketrainer.mapper.CardMapper;
import com.webapp.poketrainer.model.constants.ApiConst;
import com.webapp.poketrainer.model.pojo.card.Card;
import com.webapp.poketrainer.model.pojo.card.CardList;
import com.webapp.poketrainer.service.CardService;
import com.webapp.poketrainer.util.api.ApiCardLinkCreator;
import com.webapp.poketrainer.util.api.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
    private final ApiService apiService;
    private final ApiCardLinkCreator apiCardLinkCreator;
    private final CardService cardService;
    private final CardMapper cardMapper;
    private final Random random;

    public CardController(ApiService apiService, ApiCardLinkCreator apiCardLinkCreator, CardService cardService, CardMapper cardMapper) {
        this.apiService = apiService;
        this.apiCardLinkCreator = apiCardLinkCreator;
        this.cardService = cardService;
        this.cardMapper = cardMapper;
        this.random = new Random();
    }


    /**
     * Get 5 random cards
     * @return
     */
    @GetMapping("/getRandom")
    public void getRandomCards() throws IOException {
        List<Card> cardList = new ArrayList<>();
        for (int i = 1; i <= ApiConst.CARD_NUMBER_OF_FREE_CARDS; i++) {
            cardList.addAll(
                    cardMapper.mapJsonToCardList(
                    apiService.requestData(
                    apiCardLinkCreator.createLink(
                            random.nextInt(
                                    ApiConst.CARD_API_PAGE_VALUE)
                    ))));
        }
        cardList.forEach(cardService::addCard);
    }
/*    @GetMapping("/getRandom")
    public void getRandomCards() throws IOException {
        for (int i = 1; i <= ApiConst.CARD_NUMBER_OF_FREE_CARDS; i++) {
            String jsonPokemon = apiService.requestData(
                    apiCardLinkCreator.createLink(
                            random.nextInt(
                                    ApiConst.CARD_API_PAGE_SIZE_VALUE, ApiConst.CARD_API_PAGE_VALUE)));
            //cardService.addCard(cardService.extractCardsFromList(card));
        }

    }*/

}
