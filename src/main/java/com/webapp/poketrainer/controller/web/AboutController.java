package com.webapp.poketrainer.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for About Page
 */
@Controller
public class AboutController {

    /**
     * Method responsible for redirecting to about page
     * @return about (about.html)
     */
    @GetMapping("/about")
    public String getPage() {
        return "about";
    }
}
