package com.webapp.poketrainer.controller;

import com.webapp.poketrainer.model.dto.RegistrationRequestDto;
import com.webapp.poketrainer.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private RegistrationService registrationService;

    @GetMapping("register")
    public String getRegistrationPage(Model model) {
        RegistrationRequestDto request = new RegistrationRequestDto();
        model.addAttribute("registrationRequest", request);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registrationRequest") RegistrationRequestDto request, Model model) {
        return registrationService.register(request);
    }
}
