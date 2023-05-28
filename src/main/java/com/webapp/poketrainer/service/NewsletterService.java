package com.webapp.poketrainer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewsletterService {
    private final EmailService emailService;

    public void sendNewsletterMessage() {
        //todo
    }

}
