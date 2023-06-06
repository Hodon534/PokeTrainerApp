package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.StaticPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Home Page
 */
@Controller
public class HomeController implements StaticPage {

    /**
     * Method responsible for redirecting to home page
     * @return index (index.html)
     */
    @Override
    @GetMapping({"/", "/index", "/home"})
    public String getPage() {
        return "index";
    }


}
