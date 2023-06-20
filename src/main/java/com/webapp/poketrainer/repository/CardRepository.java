package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Pokemon Cards
 */
@Repository
public interface CardRepository extends JpaRepository<CardEntity, String> {

    /**
     * Find multiple pokemon cards by providing their name
     * @param name - pokemon name
     * @return List of Pokemon Card values from DB, if any
     */
    Optional<List<CardEntity>> findCardsByNameContaining(String name);

    /**
     * Find multiple pokemon cards by providing their owner
     * @param logged - TrainerEntity
     * @return List of Pokemon Card values from DB, if any
     */
    //Optional<List<CardEntity>> findByTrainer(TrainerEntity logged);


}
