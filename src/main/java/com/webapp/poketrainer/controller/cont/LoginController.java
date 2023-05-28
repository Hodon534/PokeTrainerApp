package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.StaticPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController implements StaticPage {

    @Override
    @GetMapping("/login")
    public String getPage() {
        return "login";
    }
}
