package com.webapp.poketrainer.model.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Stat {
    private long baseStat;
    private long effort;
    private Species stat;
}
