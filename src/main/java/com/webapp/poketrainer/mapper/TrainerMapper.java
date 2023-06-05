package com.webapp.poketrainer.mapper;

import com.webapp.poketrainer.model.dto.CardDto;
import com.webapp.poketrainer.model.dto.PokemonDto;
import com.webapp.poketrainer.model.dto.TrainerDto;
import com.webapp.poketrainer.model.entity.TrainerEntity;
import com.webapp.poketrainer.model.pojo.card.Card;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class TrainerMapper {

    private final CardMapper cardMapper;
    private final PokemonMapper pokemonMapper;

    /*public TrainerDto entityToDto(TrainerEntity trainerEntity) {
        List<PokemonDto> pokemonDtoList = new ArrayList<>();
        if (trainerEntity.getPokemons() != null) {
            pokemonDtoList = trainerEntity.getPokemons().stream().map(pokemonMapper::entityToDto).toList();
        }
        List<CardDto> cardDtoList = new ArrayList<>();
        if (trainerEntity.getCards() != null) {
            cardDtoList = trainerEntity.getCards().stream().map(cardMapper::entityToDto).toList();
        }
        return new TrainerDto(
                trainerEntity.getId(),
                trainerEntity.getName(),
                cardDtoList,
                pokemonDtoList,
                trainerEntity.getTrainerType(),
                trainerEntity.getUserEntity()
        );
    }*/

    /*public TrainerEntity dtoToEntity(TrainerDto trainerDto) {
        TrainerEntity trainerEntity = new TrainerEntity();
        trainerEntity.setId(trainerDto.getId());
        trainerEntity.setName(trainerDto.getName());
        trainerEntity.setCards(trainerDto.getCards().stream().map(cardMapper::dtoToEntity).toList());
        trainerEntity.setPokemons(trainerDto.getPokemons().stream().map(pokemonMapper::dtoToEntity).toList());
        trainerEntity.setTrainerType(trainerDto.getTrainerType());
        trainerEntity.setUserEntity(trainerDto.getUserEntity());
        return trainerEntity;
    }*/

}
