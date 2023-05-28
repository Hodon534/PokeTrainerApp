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
public class Other {
    @JsonProperty("dream_world")
    private DreamWorld dreamWorld;
}
