package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.ModelPage;
import com.webapp.poketrainer.model.dto.RegistrationRequestDto;
import com.webapp.poketrainer.service.RegistrationService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsible for Register Page
 */
@Controller
@AllArgsConstructor
public class RegistrationController implements ModelPage {
    private RegistrationService registrationService;

    /**
     * Method responsible for redirecting to registration page and parsing RegisterRequestDto into html via thymeleaf
     * @param model - RegistrationRequestDto
     * @return register (register.html)
     */
    @Override
    @GetMapping("/register")
    public String getPage(Model model) {
        RegistrationRequestDto request = new RegistrationRequestDto();
        model.addAttribute("registrationRequest", request);
        return "register";
    }

    /**
     * Method responsible for parsing Registration Request from website into proper service (RegistrationService)
     * @param request filled on website
     * @param model
     * @return request
     * @throws MessagingException
     */
    @PostMapping("/register")
    public String register(@ModelAttribute("registrationRequest") RegistrationRequestDto request, Model model) throws MessagingException {
        return registrationService.register(request);
    }

}
