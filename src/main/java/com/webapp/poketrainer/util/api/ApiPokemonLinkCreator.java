package com.webapp.poketrainer.util.api;

import com.webapp.poketrainer.model.constants.ApiConst;
import com.webapp.poketrainer.util.api.interfaces.ApiLinkCreator;
import org.springframework.stereotype.Component;

@Component
public class ApiPokemonLinkCreator implements ApiLinkCreator {

    @Override
    public String createLink(int value) {
        return ApiConst.POKEMON_API_BASE_LINK
                + ApiConst.POKEMON_API_POKEMON_TEXT
                + ApiConst.SIGN_SLASH
                + value;
    }
}
