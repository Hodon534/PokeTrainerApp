package com.webapp.poketrainer.service;

import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TrainerService {
    private TrainerRepository trainerRepository;

    /**
     * @return logged Trainer's Entity
     */
    public TrainerEntity getLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (UserEntity) auth.getPrincipal();
        return user.getTrainerEntity();
    }

    public TrainerEntity update(TrainerEntity trainerEntity) {
        return trainerRepository.save(trainerEntity);
    }
}
