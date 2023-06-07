package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.StaticPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Login Page
 */
@Controller
public class LoginController implements StaticPage {

    /**
     * Method responsible for redirecting to login page
     * @return login (login.html)
     */
    @Override
    @GetMapping("/login")
    public String getPage() {
        return "login";
    }
}
