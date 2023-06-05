package com.webapp.poketrainer.service;

import com.webapp.poketrainer.model.constants.EmailConst;
import com.webapp.poketrainer.model.dto.ContactFormDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service responsible for generating messages with reference to Contact Form on Web Page.
 */
@Service
@AllArgsConstructor
public class ContactFormService {
    private final EmailService emailService;

    /**
     * Method that is responsible for providing EmailService with emails based on filled contact form
     * @param contactForm - ContactFormDto (email, subject, body)
     * @throws MessagingException
     */
    public void sendEmail(ContactFormDto contactForm) throws MessagingException {
        emailService.send(getMimeMessageToUser(contactForm));
        emailService.send(getMimeMessageToAdmin(contactForm));
    }

    /**
     * Generate message that is being sent to user
     * @param contactForm (extract email address only)
     * @return MimeMessage that is being later send via EmailService
     * @throws MessagingException
     */
    private MimeMessage getMimeMessageToUser(ContactFormDto contactForm) throws MessagingException {
        return emailService.build(
                EmailConst.ADMIN_EMAIL_ADDRESS,
                contactForm.getEmail(),
                EmailConst.CONTACT_FORM_SUBJECT_TO_USER,
                EmailConst.CONTACT_FORM_MESSAGE_TO_USER
        );
    }

    /**
     * Generate message that is being sent to Admin /Support Service
     * @param contactForm (extract email, subject and body)
     * @return MimeMessage that is being later send via EmailService
     * @throws MessagingException
     */
    private MimeMessage getMimeMessageToAdmin(ContactFormDto contactForm) throws MessagingException {
        return emailService.build(
                EmailConst.ADMIN_EMAIL_ADDRESS,
                EmailConst.ADMIN_EMAIL_ADDRESS,
                EmailConst.CONTACT_FORM_SUBJECT_TO_ADMIN,
                getBodyOfMessageToAdmin(contactForm)
        );
    }

    /**
     * Build body of Admin's message
     * @param contactForm - build message with values based on contact form provided by user
     * @return String (body of a message)
     */
    private static String getBodyOfMessageToAdmin(ContactFormDto contactForm) {
        StringBuilder bodyOfMessageToAdmin = new StringBuilder(
                "Email from: " + contactForm.getEmail()
                        + "\nSubject: " + contactForm.getSubject()
                        + "\nMessage: " + contactForm.getMessage());
        return bodyOfMessageToAdmin.toString();
    }
}
