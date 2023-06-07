package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Trainers
 */
@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long> {
}
