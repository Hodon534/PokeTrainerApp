package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.StaticPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Card Collection Page
 */
@Controller
public class CardCollectionController implements StaticPage {

    /**
     * Method responsible for redirecting to card collection page
     * @return cardCollection (cardCollection.html)
     */
    @GetMapping("/cardCollection")
    @Override
    public String getPage() {
        return "cardCollection";
    }
}
