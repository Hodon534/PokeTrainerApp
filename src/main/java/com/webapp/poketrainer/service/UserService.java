package com.webapp.poketrainer.service;

import com.webapp.poketrainer.exception.EmailAlreadyTakenException;
import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final String USER_NOT_FOUND_MESSAGE = "User with email %s had not been found";
    private final String EMAIL_ALREADY_TAKEN_MESSAGE = "Email %s already taken";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, email)));
    }

    public void singUpUser(UserEntity user) {
        boolean userExist = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExist) {
            throw new EmailAlreadyTakenException(String.format(EMAIL_ALREADY_TAKEN_MESSAGE, user.getEmail()));
        }
        userRepository.save(user);
    }
}
