package com.webapp.poketrainer.controller.web;

import com.webapp.poketrainer.model.dto.ContactFormDto;
import com.webapp.poketrainer.service.ContactFormService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller responsible for Contact Page
 */
@Controller
@AllArgsConstructor
public class ContactController {

    private ContactFormService contactFormService;

    /**
     * Method responsible for redirecting to contact page and parsing ContactFormDto into html via thymeleaf
     * @param model - ContactFormDto
     * @return contact (contact.html)
     */
    @GetMapping("/contact")
    public String getPage(Model model) {
        ContactFormDto contactForm = new ContactFormDto();
        model.addAttribute("contactForm", contactForm);
        return "contact";
    }

    /**
     * Method responsible for parsing Contact Form from website into proper service (ContactFormService)
     * @param contactForm filled on website
     * @throws MessagingException
     */
    @PostMapping("/contact")
    public void postContactForm(@ModelAttribute("contactForm") @Valid ContactFormDto contactForm) throws MessagingException {
        contactFormService.sendEmail(contactForm);
    }
}
