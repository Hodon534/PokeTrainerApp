package com.webapp.poketrainer.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.poketrainer.model.dto.CardDto;
import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.pojo.card.Card;
import com.webapp.poketrainer.model.pojo.card.CardList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Component
public class CardMapper {
    private final ObjectMapper objectMapper;

    public CardEntity CardPojoToCardEntity(Card card) {
        return new CardEntity(
                card.getId(),
                card.getName(),
                card.getImages().getSmall());
    }

    public CardDto CardEntityToCardDto(CardEntity cardEntity) {
        return new CardDto(
                cardEntity.getId(),
                cardEntity.getName(),
                cardEntity.getSmallImage());
    }

/*    public CardList mapJsonToCardList(String input) throws IOException {
        //List<Card> cardList = new ArrayList<>();
        //return objectMapper.readValue(input, Card.class);

        return objectMapper.readValue(input, CardList.class);
    }*/

    //todo test and remove CardList class
    public List<Card> mapJsonToCardList(String input) throws IOException {
        Card[] cardArray = objectMapper.readValue(input, Card[].class);
        return Arrays.stream(cardArray).toList();
    }

}
