package com.webapp.poketrainer.service;

import com.webapp.poketrainer.model.constants.EmailConst;
import com.webapp.poketrainer.model.dto.ContactFormDto;
import jakarta.mail.Address;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactFormService {
    private final EmailService emailService;

    public void sendEmail(ContactFormDto contactForm) throws MessagingException {
        emailService.send(getMimeMessageToUser(contactForm));
        emailService.send(getMimeMessageToAdmin(contactForm));
    }

    private MimeMessage getMimeMessageToUser(ContactFormDto contactForm) throws MessagingException {
        return emailService.build(
                EmailConst.ADMIN_EMAIL_ADDRESS,
                contactForm.getEmail(),
                EmailConst.CONTACT_FORM_SUBJECT_TO_USER,
                EmailConst.CONTACT_FORM_MESSAGE_TO_USER
        );
    }

    private MimeMessage getMimeMessageToAdmin(ContactFormDto contactForm) throws MessagingException {
        return emailService.build(
                EmailConst.ADMIN_EMAIL_ADDRESS,
                EmailConst.ADMIN_EMAIL_ADDRESS,
                EmailConst.CONTACT_FORM_SUBJECT_TO_ADMIN,
                getBodyOfMessageToAdmin(contactForm)
        );
    }

    private static String getBodyOfMessageToAdmin(ContactFormDto contactForm) {
        StringBuilder bodyOfMessageToAdmin = new StringBuilder(
                "Email from: " + contactForm.getEmail()
                        + "\nSubject: " + contactForm.getSubject()
                        + "\nMessage: " + contactForm.getMessage());
        return bodyOfMessageToAdmin.toString();
    }
}
