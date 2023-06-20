package com.webapp.poketrainer.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Home Page
 */
@Controller
public class HomeController {

    /**
     * Method responsible for redirecting to home page
     * @return index (index.html)
     */
    @GetMapping({"/", "/index", "/home"})
    public String getPage() {
        return "index";
    }


}
