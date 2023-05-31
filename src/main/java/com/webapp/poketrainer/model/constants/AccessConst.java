package com.webapp.poketrainer.model.constants;

public class AccessConst {
    public final static String[] RESOURCES_PUBLIC = {
            "/css/**",
            "/images/**",
            "/js/**",
            "/register",
            "/login",
            "/about",
            "/contact",
            "/",
            "/error",
            "/api/v1/token/**"
    };

    public final static String[] RESOURCES_USER = {
            "/overview",
            "/cardCollection",
            "/catch",
            "/freebies",
            "/logout",
            "/pokedex",
            "/shop",
            "/api/v1/cards/getRandom",
            "/api/v1/pokemon/**"
    };

    public final static String[] RESOURCES_ADMIN = {
            "/admin",
            "/**"
    };
}
