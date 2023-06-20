package com.webapp.poketrainer.config;

/**
 * Spring Security Settings - PUBLIC, USER & ADMIN request Matchers
 */
class AccessConst {

    private AccessConst(){}
    /**
     * Public resources, available for everyone
     */
    protected static final String[] RESOURCES_PUBLIC = {
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
    protected static final String[] RESOURCES_USER = {
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
    protected static final String[] RESOURCES_ADMIN = {
            "/admin",
            "/**"
    };
}
