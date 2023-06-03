package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.StaticPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// todo
@Controller
public class OverviewController implements StaticPage {

    @Override
    @GetMapping("/overview")
    public String getPage() {
        return "overview";
    }
}
