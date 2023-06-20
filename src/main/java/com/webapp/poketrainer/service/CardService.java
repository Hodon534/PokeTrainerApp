package com.webapp.poketrainer.service;

import com.webapp.poketrainer.exception.CardException;
import com.webapp.poketrainer.mapper.CardMapper;
import com.webapp.poketrainer.model.constants.ApiConst;
import com.webapp.poketrainer.model.constants.ExceptionConst;
import com.webapp.poketrainer.model.constants.LogConst;
import com.webapp.poketrainer.model.dto.CardDto;
import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.pojo.card.Card;
import com.webapp.poketrainer.model.pojo.card.CardList;
import com.webapp.poketrainer.repository.CardRepository;
import com.webapp.poketrainer.util.api.ApiCardLinkCreator;
import com.webapp.poketrainer.util.api.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Transactional
@Service
@Slf4j
public class CardService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;
    private final ApiService apiService;
    private final ApiCardLinkCreator apiCardLinkCreator;
    private final Random random;
    public CardService(CardMapper cardMapper, CardRepository cardRepository, ApiService apiService, ApiCardLinkCreator apiCardLinkCreator) {
        this.cardMapper = cardMapper;
        this.cardRepository = cardRepository;
        this.apiService = apiService;
        this.apiCardLinkCreator = apiCardLinkCreator;
        this.random = new Random();
    }

    public CardEntity add(Card card) {
        return cardRepository.save(
                cardMapper.pojoToEntity(card));
    }

    public CardEntity get(String id) {
        return cardRepository.findById(id).orElseThrow(
                () -> new CardException(String.format(ExceptionConst.CARD_NOT_FOUND_EXCEPTION, id))
        );
    }

    public boolean exist(String id) {
        return cardRepository.existsById(id);
    }

    public void delete(String id) {
        cardRepository.deleteById(id);
    }

    public List<CardEntity> findAll() {
        return cardRepository.findAll();
    }
    public List<Card> getRandomCards() throws IOException {
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
        cardList.forEach(entry -> {
            if (!exist(entry.getId())) {
                add(entry);
            }
        });
        log.info(LogConst.CARD_ALL_ADDED_SUCCESSFULLY);
        return cardList;
    }
}
