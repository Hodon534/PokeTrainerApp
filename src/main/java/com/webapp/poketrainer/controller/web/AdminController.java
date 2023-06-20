package com.webapp.poketrainer.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Admin Page
 */
@Controller
public class AdminController {

    /**
     * Method responsible for redirecting to admin page
     * @return admin (admin.html)
     */
    @GetMapping("/admin")
    public String getPage() {
        return "admin";
    }



}
