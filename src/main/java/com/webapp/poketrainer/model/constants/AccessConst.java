package com.webapp.poketrainer.model.constants;

/**
 * Spring Security Settings - PUBLIC, USER & ADMIN request Matchers
 */
public class AccessConst {
    /**
     * Public resources, available for everyone
     */
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

    /**
     * User resources, available for registered and confirmed users
     */
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

    /**
     * Admin resources, available for admin
     */
    public final static String[] RESOURCES_ADMIN = {
            "/admin",
            "/**"
    };
}
