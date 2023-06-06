package com.webapp.poketrainer.service;

import com.webapp.poketrainer.mapper.CardMapper;
import com.webapp.poketrainer.model.constants.ApiConst;
import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.pojo.card.Card;
import com.webapp.poketrainer.model.pojo.card.CardList;
import com.webapp.poketrainer.repository.CardRepository;
import com.webapp.poketrainer.util.api.ApiCardLinkCreator;
import com.webapp.poketrainer.util.api.ApiService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Transactional
@Service
public class CardService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;
    private final ApiService apiService;
    private final ApiCardLinkCreator apiCardLinkCreator;
    private final Random random;
    private final TrainerService trainerService;

    public CardService(CardMapper cardMapper, CardRepository cardRepository, ApiService apiService, ApiCardLinkCreator apiCardLinkCreator, TrainerService trainerService) {
        this.cardMapper = cardMapper;
        this.cardRepository = cardRepository;
        this.apiService = apiService;
        this.apiCardLinkCreator = apiCardLinkCreator;
        this.trainerService = trainerService;
        this.random = new Random();
    }

    public CardEntity addCard(Card card, TrainerEntity trainerEntity) {
        return cardRepository.save(
                cardMapper.pojoToEntity(card, trainerEntity));
    }

    public void deleteCard(String id) {
        cardRepository.deleteById(id);
    }


    public void addRandomCards() throws IOException {
        List<Card> cardList = new ArrayList<>();
        for (int i = 1; i <= ApiConst.CARD_NUMBER_OF_FREE_CARDS; i++) {
            CardList cards = cardMapper.mapJsonToCardList(
                    apiService.requestData(
                            apiCardLinkCreator.createLink(
                                    random.nextInt(1,
                                            ApiConst.CARD_API_PAGE_VALUE)
                            )));
            cardList
                    .addAll(cards
                            .getCards()
                            .stream()
                            .toList());
        }
        TrainerEntity trainerEntity = trainerService.getLogged();
        cardList.forEach(value -> addCard(value, trainerEntity));

    }

}
