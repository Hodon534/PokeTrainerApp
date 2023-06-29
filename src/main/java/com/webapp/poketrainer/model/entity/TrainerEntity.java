package com.webapp.poketrainer.model.entity;

import com.webapp.poketrainer.model.enums.TrainerType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
//@EqualsAndHashCode
@Entity
@Table(name = "trainers")
public class TrainerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "pokemons_trainers",
            joinColumns = @JoinColumn(name = "trainers_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemons_id"))
    private Set<PokemonEntity> pokemons = new HashSet<>();
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<CardEntity, Integer> cards = new HashMap<>();
    @Enumerated(EnumType.STRING)
    @Column(name = "trainer_type", nullable = false)
    private TrainerType trainerType;
    @OneToOne
    private UserEntity user;

    public TrainerEntity(String name, UserEntity user) {
        this.name = name;
        this.trainerType = TrainerType.BEGINNER;
        this.user = user;
    }

    public TrainerEntity(Long id, String name, Map<CardEntity, Integer> cards, Set<PokemonEntity> pokemons, TrainerType trainerType, UserEntity user) {
        this.id = id;
        this.name = name;
        this.cards = cards;
        this.pokemons = pokemons;
        this.trainerType = trainerType;
        this.user = user;
    }


    public void addCard(CardEntity cardEntity) {
        if (cards.containsKey(cardEntity)) {
            cards.put(cardEntity, cards.get(cardEntity) + 1);
        } else {
            cards.put(cardEntity, 1);
        }
    }

    public void addPokemon(PokemonEntity pokemonEntity) {
        pokemons.add(pokemonEntity);
    }
}
