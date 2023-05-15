package com.webapp.poketrainer.model.enums;

/**
 * "A Poké Ball is a type of item that is critical to a Trainer's quest, used for catching and storing Pokémon."
 * source: https://bulbapedia.bulbagarden.net/wiki/Pok%C3%A9_Ball
 * 1st generation only
 */
public enum PokeBallType {
    POKE_BALL(1),
    GREAT_BALL(1.5),
    ULTRA_BALL(2),
    SAFARI_BALL(1),
    MASTER_BALL(255);

    final double catchRateModifier;

    PokeBallType(double catchRateModifier) {
        this.catchRateModifier = catchRateModifier;
    }
}
