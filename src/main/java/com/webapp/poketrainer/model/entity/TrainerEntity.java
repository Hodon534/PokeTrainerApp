package com.webapp.poketrainer.model.entity;

import com.webapp.poketrainer.model.enums.TrainerType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "trainers")
public class TrainerEntity implements Serializable {
    @Id
/*    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trainers_sequence"
    )*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    //@OneToMany(mappedBy = "trainer", cascade=CascadeType.ALL)
    /*@ElementCollection(fetch = FetchType.EAGER)
    @OneToMany(cascade=CascadeType.ALL)
    //@JoinColumn(name="trainer_id")
    private List<PokemonEntity> pokemons;*/

    //@ElementCollection(fetch = FetchType.EAGER)
    //@OneToMany(cascade=CascadeType.ALL)
    //@JoinColumn(name="trainer_id")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<CardEntity> cards;

    @Enumerated(EnumType.STRING)
    private TrainerType trainerType;

    @OneToOne
    private UserEntity userEntity;

    public TrainerEntity(String name, UserEntity userEntity) {
        this.name = name;
/*        this.pokemons = new ArrayList<>();
        this.cards = new ArrayList<>();*/
        this.trainerType = TrainerType.BEGINNER;
        this.userEntity = userEntity;
    }

   /* public void addPokemon(PokemonEntity pokemonEntity) {
        pokemons.add(pokemonEntity);
    }

    public void addCard(CardEntity cardEntity) {
        cards.add(cardEntity);
    }*/
}
