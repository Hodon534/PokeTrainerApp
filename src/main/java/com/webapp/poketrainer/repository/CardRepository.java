package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, String> {

    /**
     * Delete single pokemon card
     * @param id - unique pokemon card ID
     */
/*    void deleteCardById(String id);*/

/*    *//**
     * Find single pokemon card
     * @param id - unique pokemon card ID
     * @return Pokemon Card value from DB, if any
     *//*
    Optional<CardEntity> findCardById(String id);*/

    /**
     * Find multiple pokemon cards
     * @param name - pokemon name
     * @return List of Pokemon Card values from DB, if any
     */
    Optional<List<CardEntity>> findCardsByNameContaining(String name);
}
