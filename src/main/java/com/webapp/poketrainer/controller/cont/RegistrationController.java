package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.ModelPage;
import com.webapp.poketrainer.model.dto.RegistrationRequestDto;
import com.webapp.poketrainer.service.RegistrationService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class RegistrationController implements ModelPage {
    private RegistrationService registrationService;

    @Override
    @GetMapping("/register")
    public String getPage(Model model) {
        RegistrationRequestDto request = new RegistrationRequestDto();
        model.addAttribute("registrationRequest", request);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registrationRequest") RegistrationRequestDto request, Model model) throws MessagingException {
        return registrationService.register(request);
    }

}
