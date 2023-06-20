package com.webapp.poketrainer.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "pokemons")
public class PokemonEntity implements Serializable {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long height;
    @Column(nullable = false)
    private Long weight;
    @Column(name = "types", nullable = false)
    private List<String> pokemonTypes;
    @Column(name="base_experience", nullable = false)
    private Long baseExperience;
    @Column(name="big_image")
    private String bigImage;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "pokemons", cascade = CascadeType.ALL)
    private Set<TrainerEntity> trainers;// = new HashSet<>();


    public PokemonEntity(Long id, String name, Long height, Long weight, List<String> pokemonTypes, Long baseExperience, String bigImage, Set<TrainerEntity> trainers) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.pokemonTypes = pokemonTypes;
        this.baseExperience = baseExperience;
        this.bigImage = bigImage;
        this.trainers = trainers;
    }
}
