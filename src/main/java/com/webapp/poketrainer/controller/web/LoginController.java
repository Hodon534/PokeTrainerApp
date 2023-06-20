package com.webapp.poketrainer.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Login Page
 */
@Controller
public class LoginController {

    /**
     * Method responsible for redirecting to login page
     * @return login (login.html)
     */
    @GetMapping("/login")
    public String getPage() {
        return "login";
    }
}
