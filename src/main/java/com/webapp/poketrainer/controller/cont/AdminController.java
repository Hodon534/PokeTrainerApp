package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.StaticPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for Admin Page
 */
@Controller
public class AdminController implements StaticPage {

    /**
     * Method responsible for redirecting to admin page
     * @return admin (admin.html)
     */
    @Override
    @GetMapping("/admin")
    public String getPage() {
        return "admin";
    }



}
