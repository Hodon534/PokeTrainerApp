package com.webapp.poketrainer.controller.cont;

import com.webapp.poketrainer.controller.interfaces.ModelPage;
import com.webapp.poketrainer.model.dto.ContactFormDto;
import com.webapp.poketrainer.service.ContactFormService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ContactController implements ModelPage {

    private ContactFormService contactFormService;

    @Override
    @GetMapping("/contact")
    public String getPage(Model model) {
        ContactFormDto contactForm = new ContactFormDto();
        model.addAttribute("contactForm", contactForm);
        return "contact";
    }

    @PostMapping("/contact")
    public void getContactForm(@ModelAttribute("contactForm") ContactFormDto contactForm, Model model) throws MessagingException {
        contactFormService.sendEmail(contactForm);
    }
}
