package com.webapp.poketrainer.service.interfaces;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public interface EmailSender {
    void send(MimeMessage mimeMessage) throws MessagingException;
}
