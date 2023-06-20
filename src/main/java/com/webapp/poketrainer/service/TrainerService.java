package com.webapp.poketrainer.service;

import com.webapp.poketrainer.exception.TrainerException;
import com.webapp.poketrainer.mapper.CardMapper;
import com.webapp.poketrainer.mapper.PokemonMapper;
import com.webapp.poketrainer.model.constants.ExceptionConst;
import com.webapp.poketrainer.model.constants.LogConst;
import com.webapp.poketrainer.model.dto.CardDto;
import com.webapp.poketrainer.model.dto.PokemonDto;
import com.webapp.poketrainer.model.entity.PokemonEntity;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.model.pojo.card.Card;
import com.webapp.poketrainer.repository.TrainerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
@Slf4j
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final CardMapper cardMapper;
    /**
     * @return logged Trainer's Entity
     */
    public TrainerEntity getLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (UserEntity) auth.getPrincipal();
        return user.getTrainer();
    }

    public TrainerEntity update(TrainerEntity trainerEntity) {
        return trainerRepository.save(trainerEntity);
    }

    public TrainerEntity get(Long trainerId) {
        return trainerRepository.findById(trainerId).orElseThrow(
                () -> new TrainerException(ExceptionConst.TRAINER_DOES_NOT_EXIST_MESSAGE));
    }

        public Map<CardDto, Integer> findAllCardsHeldByLoggedUser() {
        Map<CardDto, Integer> cardDtoList = new HashMap<>();
        if (trainerRepository.findById(getLogged().getId()).isPresent()) {
            trainerRepository.findById(getLogged().getId())
                    .get()
                    .getCards()
                    .forEach((key, value) -> cardDtoList.put(cardMapper.entityToDto(key), value));
        } else {
            throw new TrainerException(ExceptionConst.TRAINER_DOES_NOT_EXIST_MESSAGE);
        }

        return cardDtoList;
    }

    public void addCards(List<Card> cardList) {
        TrainerEntity trainerEntity = getLogged();
        cardList.forEach(entry -> trainerEntity.addCard(cardMapper.pojoToEntity(entry)));
        update(trainerEntity);
        log.info(LogConst.TRAINER_HAS_BEEN_UPDATED);
    }

    public void addPokemon(PokemonEntity pokemonEntity) {
        TrainerEntity trainerEntity = getLogged();
        trainerEntity.addPokemon(pokemonEntity);
        update(trainerEntity);
        log.info(LogConst.TRAINER_HAS_BEEN_UPDATED);
    }
}
