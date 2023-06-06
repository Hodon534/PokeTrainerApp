package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.StaticPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for About Page
 */
@Controller
public class AboutController implements StaticPage {

    /**
     * Method responsible for redirecting to about page
     * @return about (about.html)
     */
    @Override
    @GetMapping("/about")
    public String getPage() {
        return "about";
    }
}
