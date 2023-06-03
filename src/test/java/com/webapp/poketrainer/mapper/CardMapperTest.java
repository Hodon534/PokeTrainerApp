package com.webapp.poketrainer.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.poketrainer.model.dto.CardDto;
import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.pojo.card.Card;
import com.webapp.poketrainer.model.pojo.card.Images;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CardMapperTest {

    @Autowired
    private static CardMapper underTest;

    @BeforeAll
    static void beforeAll() {
        underTest = new CardMapper(new ObjectMapper());
    }

    @Test
    void pojoToEntity() {
        // given
        Card card = new Card();
        card.setId("ex5-19");
        card.setName("Huntail");
        card.setImages(new Images());
        card.getImages().setSmall("https://images.pokemontcg.io/ex5/19.png");
        // when
        CardEntity cardEntity = underTest.pojoToEntity(card);
        // then
        assertAll(
                () -> assertEquals(cardEntity.getId(), card.getId()),
                () -> assertEquals(cardEntity.getName(), card.getName()),
                () -> assertEquals(cardEntity.getSmallImage(), card.getImages().getSmall())
        );
    }

    @Test
    void entityToDto() {
        // given
        CardEntity cardEntity = new CardEntity(
                "ex5-19",
                "Huntail",
                "https://images.pokemontcg.io/ex5/19.png"
        );
        // when
        CardDto cardDto = underTest.entityToDto(cardEntity);
        // then
        assertAll(
                () -> assertEquals(cardDto.getId(), cardEntity.getId()),
                () -> assertEquals(cardDto.getName(), cardEntity.getName()),
                () -> assertEquals(cardDto.getSmallImage(), cardEntity.getSmallImage())
        );
    }

    @Test
    void mapJsonToCardList() {
    }
}