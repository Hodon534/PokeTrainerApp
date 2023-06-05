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

/**
 * Pokemon Card Mapper:
 * String -> CardList
 * Card -> CardEntity
 * CardEntity -> CardDto
 */
@AllArgsConstructor
@Component
public class CardMapper {
    private final ObjectMapper objectMapper;

    /**
     * Map Card from CardList from pokeapi.co into database appropriate entity
     * @param card from CardList
     * @return CardEntity
     */
    public CardEntity pojoToEntity(Card card) {
        return new CardEntity(
                card.getId(),
                card.getName(),
                card.getImages().getSmall());
    }
    /**
     * Map CardEntity to an Object
     * @param cardEntity from DataBase
     * @return CardDto
     */
    public CardDto entityToDto(CardEntity cardEntity) {
        return new CardDto(
                cardEntity.getId(),
                cardEntity.getName(),
                cardEntity.getSmallImage());
    }


    public CardEntity dtoToEntity(CardDto cardDto) {
        return new CardEntity(
                cardDto.getId(),
                cardDto.getName(),
                cardDto.getSmallImage());
    }
    /**
     * Map Card from CardList to CardDto
     * @param card from CardList (POJO)
     * @return CardDto
     */
    public CardDto pojoToDto(Card card) {
        return new CardDto(
                card.getId(),
                card.getName(),
                card.getImages().getSmall());
    }

    /**
     * Map String from pokeapi.co into CardList Object
     * @param input - json as String
     * @return CardList, that contains a List of Cards
     * @throws IOException
     */
    public CardList mapJsonToCardList(String input) throws IOException {
        return objectMapper.readValue(input, CardList.class);
    }

}
