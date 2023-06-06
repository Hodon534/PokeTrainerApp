package com.webapp.poketrainer.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.poketrainer.model.dto.CardDto;
import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.pojo.card.Card;
import com.webapp.poketrainer.model.pojo.card.Images;
import com.webapp.poketrainer.service.TrainerService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CardMapperTest {

    @Autowired
    private static CardMapper underTest;
    @Autowired
    private static TrainerService trainerService;

    @BeforeAll
    static void beforeAll() {
        underTest = new CardMapper(new ObjectMapper(), trainerService);
    }

    @Test
    void pojoToEntity() {
        // given
        Card card = new Card();
        card.setId("ex5-19");
        card.setName("Huntail");
        card.setImages(new Images());
        card.getImages().setSmall("https://images.pokemontcg.io/ex5/19.png");
        TrainerEntity trainerEntity = new TrainerEntity();
        // when
        CardEntity cardEntity = underTest.pojoToEntity(card, trainerEntity);
        // then
        assertAll(
                () -> assertEquals(cardEntity.getId(), card.getId()),
                () -> assertEquals(cardEntity.getName(), card.getName()),
                () -> assertEquals(cardEntity.getSmallImage(), card.getImages().getSmall()),
                () -> assertEquals(cardEntity.getTrainer(), trainerEntity)
        );
    }

    @Test
    void entityToDto() {
        // given
        CardEntity cardEntity = new CardEntity(
                "ex5-19",
                "Huntail",
                "https://images.pokemontcg.io/ex5/19.png",
                new TrainerEntity()
        );
        // when
        CardDto cardDto = underTest.entityToDto(cardEntity);
        // then
        assertAll(
                () -> assertEquals(cardDto.getId(), cardEntity.getId()),
                () -> assertEquals(cardDto.getName(), cardEntity.getName()),
                () -> assertEquals(cardDto.getSmallImage(), cardEntity.getSmallImage()),
                () -> assertEquals(cardDto.getTrainerId(), cardEntity.getTrainer().getId())
        );
    }

    @Test
    @Disabled
    void dtoToEntity() {
        // given
        TrainerEntity trainerEntity = new TrainerEntity();
        CardDto cardDto = new CardDto(
                "ex5-19",
                "Huntail",
                "https://images.pokemontcg.io/ex5/19.png",
                trainerEntity.getId()
        );
        // when
        CardEntity cardEntity = underTest.dtoToEntity(cardDto);
        // then
        assertAll(
                () -> assertEquals(cardEntity.getId(), cardDto.getId()),
                () -> assertEquals(cardEntity.getName(), cardDto.getName()),
                () -> assertEquals(cardEntity.getSmallImage(), cardDto.getSmallImage()),
                () -> assertEquals(cardEntity.getTrainer(), trainerEntity)
        );
    }

    @Test
    void testMapJsonToCardList() {
    }
}