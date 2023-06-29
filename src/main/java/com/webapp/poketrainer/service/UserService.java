package com.webapp.poketrainer.service;

import com.webapp.poketrainer.exception.EmailException;
import com.webapp.poketrainer.exception.UserException;
import com.webapp.poketrainer.model.constants.EmailConst;
import com.webapp.poketrainer.model.constants.ExceptionConst;
import com.webapp.poketrainer.model.entity.ConfirmationTokenEntity;
import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.webapp.poketrainer.model.constants.ExceptionConst.USER_NOT_FOUND_EXCEPTION;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByUsername(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(String.format(ExceptionConst.USER_NOT_FOUND_MESSAGE, email)));
    }

    public UserEntity get(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserException(String.format(USER_NOT_FOUND_EXCEPTION, id))
        );
    }

    public String singUpUser(UserEntity user) {
        boolean userExist = userRepository.findByUsername(user.getUsername()).isPresent();
        if (userExist) {
            throw new EmailException(String.format(ExceptionConst.EMAIL_ALREADY_TAKEN_MESSAGE, user.getUsername()));
        }
        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationTokenEntity confirmationToken = getConfirmationTokenEntity(user, token);
        confirmationTokenService.save(confirmationToken);

        return token;
    }

    private static ConfirmationTokenEntity getConfirmationTokenEntity(UserEntity user, String token) {
        return new ConfirmationTokenEntity(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(EmailConst.TOKEN_MINUTES_CONFIRMATION),
                user
        );
    }

    public int enableUser(String email) {
        return userRepository.enableUserEntity(email);
    }


}
