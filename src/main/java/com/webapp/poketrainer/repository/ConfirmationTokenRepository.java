package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.ConfirmationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repository for Confirmation Tokens
 */
@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenEntity, Long> {

    /**
     * Find confirmation token by providing token sent to user
     * @param token - String send to user
     * @return ConfirmationTokenEntity, if any
     */
    Optional<ConfirmationTokenEntity> findByToken(String token);

    /**
     * Update confirmation token as confirmed
     * @param token - String send to user
     * @param confirmedAt - LocalDateTime at which the user has confirmed their email
     * @return int (1 = enabled)
     */
    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationTokenEntity c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);
}
