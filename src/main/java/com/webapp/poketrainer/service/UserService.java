package com.webapp.poketrainer.service;

import com.webapp.poketrainer.exception.EmailAlreadyTakenException;
import com.webapp.poketrainer.model.constants.EmailConst;
import com.webapp.poketrainer.model.constants.ExceptionConst;
import com.webapp.poketrainer.model.entity.ConfirmationTokenEntity;
import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(String.format(ExceptionConst.USER_NOT_FOUND_MESSAGE, email)));
    }

    public String singUpUser(UserEntity user) {
        boolean userExist = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExist) {
            throw new EmailAlreadyTakenException(String.format(ExceptionConst.EMAIL_ALREADY_TAKEN_MESSAGE, user.getEmail()));
        }
        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationTokenEntity confirmationToken = getConfirmationTokenEntity(user, token);
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    private static ConfirmationTokenEntity getConfirmationTokenEntity(UserEntity user, String token) {
        ConfirmationTokenEntity confirmationToken = new ConfirmationTokenEntity(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(EmailConst.TOKEN_MINUTES_CONFIRMATION),
                user
        );
        return confirmationToken;
    }

    public int enableUser(String email) {
        return userRepository.enableUserEntity(email);
    }


}

//        //trainerRepository.save(user.getTrainerEntity());