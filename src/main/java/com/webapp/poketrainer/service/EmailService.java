package com.webapp.poketrainer.service;

import com.webapp.poketrainer.service.interfaces.EmailBuilder;
import com.webapp.poketrainer.service.interfaces.EmailSender;
import jakarta.mail.Address;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Service responsible for Email Handling, such as sending and building.
 */
@Service
@AllArgsConstructor
public class EmailService implements EmailSender, EmailBuilder {
    private final JavaMailSender javaMailSender;

    /**
     * Send Email Message with use of JavaMailSender
     * @param mimeMessage - message that is being sent to specific email address
     * @throws MessagingException
     */
    @Async
    @Override
    public void send(MimeMessage mimeMessage) throws MessagingException {
        javaMailSender.send(mimeMessage);
    }

    /**
     * Build Email Message as MimeMessage with arguments provided in other methods
     * @param fromEmail - Email Address from which mail should be sent
     * @param toEmail - Email Address to which mail should be sent
     * @param subject - Subject of Email
     * @param message - Body of Email
     * @return MimeMessage that is ready to send
     * @throws MessagingException
     */
    @Override
    public MimeMessage build(String fromEmail, String toEmail, String subject, String message) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        mimeMessage.setFrom(fromEmail);
        Address userAddress = new InternetAddress(toEmail);
        mimeMessage.setRecipient(Message.RecipientType.TO, userAddress);
        mimeMessage.setSubject(subject);
        mimeMessage.setText(message);

        return mimeMessage;
    }
}