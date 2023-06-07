package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Pokemons
 */
@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
}
