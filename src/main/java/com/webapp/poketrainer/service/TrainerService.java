package com.webapp.poketrainer.service;

import com.webapp.poketrainer.exception.CardsNotFoundException;
import com.webapp.poketrainer.exception.TrainerNotFoundException;
import com.webapp.poketrainer.model.constants.ExceptionConst;
import com.webapp.poketrainer.model.entity.CardEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public TrainerEntity get(Long trainerId) {
        return trainerRepository.findById(trainerId).orElseThrow(
                () -> new TrainerNotFoundException(ExceptionConst.TRAINER_DOES_NOT_EXIST_MESSAGE));
    }

}
