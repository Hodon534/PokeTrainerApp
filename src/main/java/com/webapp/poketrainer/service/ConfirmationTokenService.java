package com.webapp.poketrainer.service;

import com.webapp.poketrainer.model.constants.LogConst;
import com.webapp.poketrainer.model.entity.ConfirmationTokenEntity;
import com.webapp.poketrainer.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Service responsible for handling tokens which are being used for registration purposes.
 */
@Service
@AllArgsConstructor
@Slf4j
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    /**
     * Save ConfirmationToken entity to Database
     * @param token - generated in RegistrationService
     */
    public void save(ConfirmationTokenEntity token) {
        confirmationTokenRepository.save(token);
    }

    /**
     * Extract ConfirmationToken entity from Database by provided token (String)
     * @param token - String that is being sent to user via email
     * @return ConfirmationTokenEntity if available
     */
    public Optional<ConfirmationTokenEntity> get(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    /**
     * Set Confirmation Token as confirmed
     * @param token - String that is being sent to user via email
     * @return int - changes token as confirmed
     */
    public int setConfirmedAt(String token) {
        log.info(LogConst.TOKEN_CONFIRMED);
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
