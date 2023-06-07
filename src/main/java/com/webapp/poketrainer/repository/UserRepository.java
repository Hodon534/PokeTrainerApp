package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Repository for Users
 */
@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Find specific user by providing their email
     * @param email - String (user's email)
     * @return UserEntity, if any
     */
    Optional<UserEntity> findByEmail(String email);

    /**
     * Set user as enabled
     * @param email - String (user's email)
     * @return int (1 = enabled)
     */
    @Transactional
    @Modifying
    @Query("UPDATE UserEntity a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUserEntity(String email);
}
