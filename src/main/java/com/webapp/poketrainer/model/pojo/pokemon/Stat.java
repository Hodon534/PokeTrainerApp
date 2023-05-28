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
public class Stat {
    @JsonProperty("base_stat")
    private long baseStat;
    private long effort;
    private Species stat;
}
