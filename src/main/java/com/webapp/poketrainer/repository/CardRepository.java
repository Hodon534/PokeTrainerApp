package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, String> {

    /**
     * Find multiple pokemon cards
     * @param name - pokemon name
     * @return List of Pokemon Card values from DB, if any
     */
    Optional<List<CardEntity>> findCardsByNameContaining(String name);

    Optional<List<CardEntity>> findByTrainer(TrainerEntity logged);


}
