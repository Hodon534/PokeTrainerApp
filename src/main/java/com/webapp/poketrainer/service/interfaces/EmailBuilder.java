package com.webapp.poketrainer.service.interfaces;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public interface EmailBuilder {

    MimeMessage build(String fromEmail, String toEmail, String subject, String message) throws MessagingException;
}
