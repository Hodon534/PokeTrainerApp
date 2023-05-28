package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {

    /**
     * Find single Pokemon by it's ID
     * @param id - unique pokemon ID
     * @return Pokemon from database, if any
     */
    Optional<PokemonEntity> findPokemonById(Long id);

}
