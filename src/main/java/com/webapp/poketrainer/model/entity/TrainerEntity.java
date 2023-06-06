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
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "trainers")
public class TrainerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //, mappedBy = "trainers"
    @JoinTable(
            name = "pokemons_trainers",
            joinColumns = @JoinColumn(name = "trainers_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemons_id"))
    private Set<PokemonEntity> pokemons;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "trainer", cascade = CascadeType.ALL) //, cascade = CascadeType.ALL
    private List<CardEntity> cards;
    @Enumerated(EnumType.STRING)
    private TrainerType trainerType;
    @OneToOne
    private UserEntity userEntity;

    public TrainerEntity(String name, UserEntity userEntity) {
        this.name = name;
        this.trainerType = TrainerType.BEGINNER;
        this.userEntity = userEntity;
    }

   /* public void addPokemon(PokemonEntity pokemonEntity) {
        pokemons.add(pokemonEntity);
    }*/

    public void addCard(CardEntity cardEntity) {
        cards.add(cardEntity);
    }
}
