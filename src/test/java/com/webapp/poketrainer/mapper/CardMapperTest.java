package com.webapp.poketrainer.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.poketrainer.model.dto.CardDto;
import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.pojo.card.Card;
import com.webapp.poketrainer.model.pojo.card.Images;
import com.webapp.poketrainer.repository.TrainerRepository;
import com.webapp.poketrainer.service.TrainerService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@AllArgsConstructor
class CardMapperTest {

    @Autowired
    private static CardMapper underTest;
    @Autowired
    private static TrainerService trainerService;
    @Mock
    private static TrainerRepository trainerRepository;

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
    @Disabled
    void dtoToEntity() {
        // given
        CardDto cardDto = new CardDto(
                "ex5-19",
                "Huntail",
                "https://images.pokemontcg.io/ex5/19.png"
        );
        // when
        CardEntity cardEntity = underTest.dtoToEntity(cardDto);
        // then
        assertAll(
                () -> assertEquals(cardEntity.getId(), cardDto.getId()),
                () -> assertEquals(cardEntity.getName(), cardDto.getName()),
                () -> assertEquals(cardEntity.getSmallImage(), cardDto.getSmallImage())
        );
    }

    @Test
    void testMapJsonToCardList() {
    }
}