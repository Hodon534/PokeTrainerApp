package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.StaticPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Freebies Page
 */
@Controller
public class FreebiesController implements StaticPage {

    /**
     * Method responsible for redirecting to freebies page
     * @return freebies (freebies.html)
     */
    @GetMapping("/freebies")
    @Override
    public String getPage() {
        return "freebies";
    }
}
