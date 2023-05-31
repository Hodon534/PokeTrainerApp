package com.webapp.poketrainer.service;

import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    /**
     * @return logged Trainer's Entity
     */
    public TrainerEntity getLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (UserEntity) auth.getPrincipal();
        return user.getTrainerEntity();
    }
}
