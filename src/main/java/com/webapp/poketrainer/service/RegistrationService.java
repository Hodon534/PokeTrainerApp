package com.webapp.poketrainer.service;

import com.webapp.poketrainer.exception.EmailException;
import com.webapp.poketrainer.exception.TokenException;
import com.webapp.poketrainer.model.constants.EmailConst;
import com.webapp.poketrainer.model.constants.ExceptionConst;
import com.webapp.poketrainer.model.constants.LogConst;
import com.webapp.poketrainer.model.dto.RegistrationRequestDto;
import com.webapp.poketrainer.model.entity.ConfirmationTokenEntity;
import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.model.enums.UserRole;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Service responsible for registering new users
 */
@Service
@AllArgsConstructor
@Slf4j
public class RegistrationService {
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailService emailService;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String register(RegistrationRequestDto request) throws MessagingException {
        String token = userService.singUpUser(
                new UserEntity(
                    request.getUsername(),
                    request.getNickname(),
                    bCryptPasswordEncoder.encode(request.getPassword()),
                    UserRole.USER
        ));
        sendToken(request, token);
        log.info(LogConst.USER_NEW_REGISTERED);
        return "register";
    }

    private void sendToken(RegistrationRequestDto request, String token) throws MessagingException {
        String link = EmailConst.TOKEN_BASE_LINK + token;
        emailService.send(
                emailService.build(
                        EmailConst.ADMIN_EMAIL_ADDRESS,
                        request.getUsername(),
                        EmailConst.TOKEN_MESSAGE_SUBJECT,
                        EmailConst.TOKEN_MESSAGE_BODY + link));
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationTokenEntity confirmationToken = confirmationTokenService
                .get(token)
                .orElseThrow(() ->
                        new TokenException(ExceptionConst.TOKEN_NOT_FOUND_MESSAGE));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new EmailException(ExceptionConst.EMAIL_ALREADY_CONFIRMED_MESSAGE);
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new TokenException(ExceptionConst.TOKEN_EXPIRED_MESSAGE);
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getUsername());
        return "confirmed";
    }
}
