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
    @Column(name="Name")
    private String name;
    @Column(name="Height")
    private Long height;
    @Column(name="Weight")
    private Long weight;
    @Column(name="Types")
    private List<String> pokemonTypes;
    @Column(name="Base Experience")
    private Long baseExperience;
    @Column(name="Big Image")
    private String bigImage;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<TrainerEntity> trainers;

    public PokemonEntity(Long id, String name, Long height, Long weight, List<String> pokemonTypes, Long baseExperience, String bigImage) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.pokemonTypes = pokemonTypes;
        this.baseExperience = baseExperience;
        this.bigImage = bigImage;
    }
}
