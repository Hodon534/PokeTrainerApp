package com.webapp.poketrainer.model.enums;

/**
 * -> Number of Pokémon that are available in first generation.
 */
public enum PokemonGeneration {
    I_GEN(1, 151, "I GEN"),
    II_GEN(152, 251, "II GEN"),
    III_GEN(252, 386, "III GEN"),
    IV_GEN(387, 493, "IV GEN"),
    V_GEN(494, 649, "V GEN"),
    VI_GEN(650, 721, "VI_GEN"),
    VII_GEN(722, 809, "VII GEN"),
    VIII_GEN(810, 905, "VIII GEN"),
    IX_GEN(906, 1016, "IX GEN"),
    ALL(I_GEN.indexStart, IX_GEN.indexEnd, "ALL");

    public final int indexStart;
    public final int indexEnd;
    public final String gen;

    PokemonGeneration(int indexStart, int indexEnd, String gen) {
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
        this.gen = gen;
    }

    public String getGen() {
        return gen;
    }
}
