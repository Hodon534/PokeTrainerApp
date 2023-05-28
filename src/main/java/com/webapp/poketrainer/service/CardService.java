package com.webapp.poketrainer.service;

import com.webapp.poketrainer.mapper.CardMapper;
import com.webapp.poketrainer.model.dto.CardDto;
import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.pojo.card.Card;
import com.webapp.poketrainer.model.pojo.card.CardList;
import com.webapp.poketrainer.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class CardService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;

    public CardEntity addCard(Card card) {
        return cardRepository.save(
                cardMapper.CardPojoToCardEntity(card));
    }

    public void deleteCard(String id) {
        cardRepository.deleteCardById(id);
    }


    public List<Card> extractCardsFromCardList(CardList cardList) {
        List<Card> list = new ArrayList<>();
        for (Card card : cardList.getCards()) {
            list.add(card);
        }
        return list;
    }

}
