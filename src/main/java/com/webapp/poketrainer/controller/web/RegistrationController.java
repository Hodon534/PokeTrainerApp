package com.webapp.poketrainer.controller.web;

import com.webapp.poketrainer.model.dto.RegistrationRequestDto;
import com.webapp.poketrainer.service.RegistrationService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsible for Register Page
 */
@Controller
@AllArgsConstructor
public class RegistrationController {
    private RegistrationService registrationService;

    /**
     * Method responsible for redirecting to registration page and parsing RegisterRequestDto into html via thymeleaf
     * @param model - RegistrationRequestDto
     * @return register (register.html)
     */
    @GetMapping("/register")
    public String getPage(Model model) {
        RegistrationRequestDto request = new RegistrationRequestDto();
        model.addAttribute("registrationRequest", request);
        return "register";
    }

    /**
     * Method responsible for parsing Registration Request from website into proper service (RegistrationService)
     * @param request filled on website
     * @return request
     * @throws MessagingException
     */
    @PostMapping("/register") // javax validation
    public String register(@ModelAttribute("registrationRequest") @Valid RegistrationRequestDto request) throws MessagingException {
        return registrationService.register(request);
    }

}
