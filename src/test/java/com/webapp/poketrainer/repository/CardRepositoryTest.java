package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest // Test Repository
class CardRepositoryTest {

    @Autowired
    private CardRepository underTest;

    @Autowired
    private TrainerRepository trainerRepository;

    @Test
    void shouldFindCardsByNameContaining() {
        // given
        String searchedName = "Huntail";
        CardEntity firstCard = new CardEntity(
                "ex5-19",
                "Huntail",
                "https://images.pokemontcg.io/ex5/19.png"
        );
        CardEntity secondCard = new CardEntity(
                "bx-234",
                "Huntail & Hutsky",
                "https://images.pokemontcg.io/ex5/192.png"
        );
        List<CardEntity> cardList = List.of(firstCard, secondCard);
        // when
        underTest.saveAll(cardList);
        Optional<List<CardEntity>> optionalList = underTest.findCardsByNameContaining(searchedName);
        // then
        assertTrue(optionalList.isPresent());
        assertAll(
                () -> assertTrue(optionalList.get().contains(firstCard)),
                () -> assertTrue(optionalList.get().contains(secondCard)),
                () -> assertEquals(optionalList.get(), cardList)
        );
    }

    @Test
    void shouldNotFindCardsByNameContaining() {
        // given
        String searchedName = "Bulbasaur";
        CardEntity firstCard = new CardEntity(
                "ex5-19",
                "Huntail",
                "https://images.pokemontcg.io/ex5/19.png"
        );
        CardEntity secondCard = new CardEntity(
                "bx-234",
                "Huntail & Hutsky",
                "https://images.pokemontcg.io/ex5/192.png"
        );
        List<CardEntity> cardList = List.of(firstCard, secondCard);
        // when
        underTest.saveAll(cardList);
        Optional<List<CardEntity>> optionalList = underTest.findCardsByNameContaining(searchedName);
        // then
        assertFalse(optionalList.isEmpty());
    }

    @Test
    void shouldFindByTrainer() {
        CardEntity firstCard = new CardEntity(
                "bw10-57",
                "Aron",
                "https://images.pokemontcg.io/bw10/57.png"
        );
        CardEntity secondCard = new CardEntity(
                "dp1-101",
                "Starly",
                "https://images.pokemontcg.io/dp1/101.png"
        );
        CardEntity thirdCard = new CardEntity(
                "dp1-102",
                "Stunky",
                "https://images.pokemontcg.io/dp1/102.png"
        );
        List<CardEntity> cardList = List.of(firstCard, secondCard, thirdCard);
        // when
        underTest.saveAll(cardList);
        /*Optional<List<CardEntity>> firstOptionalCardList = underTest.findByTrainer(firstTrainer);
        Optional<List<CardEntity>> secondOptionalCardList = underTest.findByTrainer(secondTrainer);
        // then
        assertAll(
                () -> assertTrue(firstOptionalCardList::isPresent),
                () -> assertTrue(secondOptionalCardList::isPresent),
                () -> assertEquals(firstOptionalCardList.get(), List.of(firstCard, thirdCard)),
                () -> assertEquals(secondOptionalCardList.get(), List.of(secondCard))*/

    }

    @Test
    void shouldNotFindByTrainer() {
        /*TrainerEntity firstTrainer = new TrainerEntity();
        trainerRepository.save(firstTrainer);
        TrainerEntity secondTrainer = new TrainerEntity();
        trainerRepository.save(secondTrainer);
        CardEntity firstCard = new CardEntity(
                "bw10-57",
                "Aron",
                "https://images.pokemontcg.io/bw10/57.png",
                firstTrainer
        );
        CardEntity secondCard = new CardEntity(
                "dp1-101",
                "Starly",
                "https://images.pokemontcg.io/dp1/101.png",
                firstTrainer
        );
        CardEntity thirdCard = new CardEntity(
                "dp1-102",
                "Stunky",
                "https://images.pokemontcg.io/dp1/102.png",
                firstTrainer
        );
        List<CardEntity> cardList = List.of(firstCard, secondCard, thirdCard);
        // when
        underTest.saveAll(cardList);
        Optional<List<CardEntity>> optionalCardList = underTest.findByTrainer(secondTrainer);
        // then
        assertFalse(optionalCardList.isEmpty());*/
    }
}