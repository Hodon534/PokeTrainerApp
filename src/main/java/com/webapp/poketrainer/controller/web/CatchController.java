package com.webapp.poketrainer.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatchController {

    @GetMapping("/catch")
    public String getPage() {
        return "catch";
    }
}
