package com.webapp.poketrainer.repository;

import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.model.enums.UserRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }
    @Test
    void itShouldCheckIfEmailExist() {
        //given
        String email = "someEmail@email.com";
        UserEntity user = new UserEntity(
                "someUser",
                email,
                "password",
                UserRole.USER
        );
        underTest.save(user);
        //when
        Optional<UserEntity> anotherUser = underTest.findByEmail(email);
        //then
        assertTrue(anotherUser.isPresent());
    }

    @Test
    void itShouldCheckThatEmailDoesNotExist() {
        //given
        String email = "testingEmail@email.com";
        //when
        Optional<UserEntity> anotherUser = underTest.findByEmail(email);
        //then
        assertFalse(anotherUser.isPresent());
    }

/*    @Test
    void makeSureThatEnablingUserWorks() {
        //given
        String email = "someEmail@email.com";
        UserEntity user = new UserEntity(
                "someUser",
                email,
                "password",
                UserRole.USER
        );
        underTest.save(user);
        boolean enabled = true;
        //when
        underTest.enableUserEntity(email);
        boolean ifUserEnabled = user.getEnabled();
        //then
        assertEquals(enabled, ifUserEnabled);
    }*/

    @Test
    void makeSureThatUsersAreDisabledAfterRegistering() {
        //given
        String email = "someEmail@email.com";
        UserEntity user = new UserEntity(
                "someUser",
                email,
                "password",
                UserRole.USER
        );
        underTest.save(user);
        boolean notEnabled = false;
        //when
        boolean ifUserEnabled = user.getEnabled();
        //then
        assertEquals(notEnabled, ifUserEnabled);
    }
}