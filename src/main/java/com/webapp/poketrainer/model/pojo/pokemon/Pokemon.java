package com.webapp.poketrainer.model.pojo.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pokemon {
    @JsonProperty("base_experience")
    private long baseExperience;
    private long height;
    private long id;
    private String name;
    private Sprites sprites;
    private Stat[] stats;
    private Type[] types;
    private long weight;
}
