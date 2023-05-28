package com.webapp.poketrainer.util.api;

import com.webapp.poketrainer.model.constants.ApiConst;
import com.webapp.poketrainer.util.api.interfaces.ApiLinkCreator;
import org.springframework.stereotype.Component;

@Component
public class ApiCardLinkCreator implements ApiLinkCreator {

    @Override
    public String createLink(int value) {
        return ApiConst.CARD_API_BASE_LINK
                + ApiConst.SIGN_QUESTION_MARK
                + ApiConst.CARD_API_PAGE_TEXT
                + value
                + ApiConst.SIGN_AND
                + ApiConst.CARD_API_PAGE_SIZE_TEXT
                + ApiConst.SIGN_EQUALS
                + ApiConst.CARD_API_PAGE_SIZE_VALUE;
    }
}
