package com.webapp.poketrainer.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Freebies Page
 */
@Controller
public class FreebiesController {

    /**
     * Method responsible for redirecting to freebies page
     * @return freebies (freebies.html)
     */
    @GetMapping("/freebies")
    public String getPage() {
        return "freebies";
    }
}
