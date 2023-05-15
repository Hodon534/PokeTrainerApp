package com.webapp.poketrainer.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemon")
public class PokemonEntity {
    @Id
    private Long id;
    private String name;
    private Long height;
    private Long weight;
    //@Enumerated(EnumType.STRING)
    private List<String> pokemonTypes;
    private Long baseExperience;
    private String bigImage;

}
