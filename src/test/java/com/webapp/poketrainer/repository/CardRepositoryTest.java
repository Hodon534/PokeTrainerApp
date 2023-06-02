package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.CardEntity;
import org.junit.jupiter.api.Disabled;
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
    @Test
    void deleteCardById() {
        // given
        String id = "ex5-19";
        CardEntity card = new CardEntity(
                id,
                "Huntail",
                "https://images.pokemontcg.io/ex5/19.png"
        );
        // when
        underTest.save(card);
        Optional<CardEntity> optionalCard = underTest.findById(id);
        // then
        assertTrue(optionalCard.isPresent());
        underTest.deleteCardById(id);
        assertFalse(underTest.findById(id).isPresent());

    }

    @Test
    @Disabled
    void findCardById() {
    }

    @Test
    @Disabled
    void findCardsByNameContaining() {
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

        // then
        Optional<List<CardEntity>> optionalList = underTest.findCardsByNameContaining(searchedName);
        assertTrue(optionalList.isPresent());
        System.out.println(optionalList.get().get(0));
        System.out.println(optionalList.get().get(1));
        assertTrue(optionalList.get().contains(firstCard));
        assertTrue(optionalList.get().contains(secondCard));


    }
}