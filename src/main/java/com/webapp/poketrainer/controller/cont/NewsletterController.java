package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.StaticPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// todo
@Controller
public class NewsletterController implements StaticPage {

    @Override
    @GetMapping("/newsletter")
    public String getPage() {
        return "newsletter";
    }
}
