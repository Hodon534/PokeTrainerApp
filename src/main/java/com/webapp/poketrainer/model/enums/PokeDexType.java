package com.webapp.poketrainer.model.enums;

/**
 * "The Pokédex is an invaluable tool to Trainers in the Pokémon world.
 * It gives information about all Pokémon in the world that are contained in its database"
 * source: https://bulbapedia.bulbagarden.net/wiki/Pok%C3%A9dex
 * -> Number of Pokémon that are available in first generation.
 */
public enum PokeDexType {
    I_GEN(151);
    /**
     * Number of Pokémon that are available in first generation.
     */
    public final int numberOfEntries;

    PokeDexType(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }
}
