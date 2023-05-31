package com.webapp.poketrainer.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.poketrainer.model.dto.CardDto;
import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.pojo.card.Card;
import com.webapp.poketrainer.model.pojo.card.CardList;
import com.webapp.poketrainer.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor
@Component
public class CardMapper {
    private final ObjectMapper objectMapper;
    private final TrainerRepository trainerRepository;

    public CardEntity pojoToEntity(Card card) {
        return new CardEntity(
                card.getId(),
                card.getName(),
                card.getImages().getSmall());
    }

/*
    public CardEntity pojoToEntity(Card card, TrainerEntity trainerEntity) {
        return new CardEntity(
                card.getId(),
                card.getName(),
                card.getImages().getSmall(),
                trainerEntity);
    }
*/

    public CardDto entityToDto(CardEntity cardEntity) {
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
    public CardList mapJsonToCardList(String input) throws IOException {
        return objectMapper.readValue(input, CardList.class);
    }

}
