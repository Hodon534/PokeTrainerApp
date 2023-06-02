package com.webapp.poketrainer.service;

import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.model.enums.UserRole;
import com.webapp.poketrainer.repository.UserRepository;import org.apache.catalina.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.DomainEvents;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mockito.Mockito.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ConfirmationTokenService confirmationTokenService;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository, confirmationTokenService);
    }

    @Test
    @Disabled
    void checkIfItCanLoadExistingUserByEmail() {
        // given
        String email = "someEmail@email.com";
        UserEntity user = new UserEntity(
                "someUser",
                email,
                "password",
                UserRole.USER
        );
        // when;
        verify(userRepository).save(user);
        UserDetails userDetails = underTest.loadUserByUsername(email);

        // then
        assertAll(
                ()-> assertNotNull(userDetails),
                ()-> assertEquals(userDetails.getUsername(), email)
        );


    }

    @Test
    void checkIfItDoesNotFindUserThatDoesNotExist() {
    }

    @Test
    @Disabled
    void singUpUser() {
    }

    @Test
    @Disabled
    void enableUser() {
    }
}