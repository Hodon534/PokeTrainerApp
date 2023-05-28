package com.webapp.poketrainer.model.constants;

/**
 * Constants that are related to sending emails
 */
public class EmailConst {
    /**
     * Email address from which emails are being sent to users
     */
    public final static String ADMIN_EMAIL_ADDRESS = "springtesting123125@gmail.com";
    public final static String CONTACT_FORM_MESSAGE_TO_USER = "Thank you for contacting with us, we'll get back to you as soon as possible.";
    public final static String CONTACT_FORM_SUBJECT_TO_USER = "Contact form message received";
    public final static String CONTACT_FORM_SUBJECT_TO_ADMIN = "You've received new message!";
    public final static String TOKEN_BASE_LINK = "http://localhost:8080/api/v1/token/confirm?token=";
    public final static String TOKEN_MESSAGE_SUBJECT = "Confirm your email";
    public final static String TOKEN_MESSAGE_BODY = "Your confirmation token: ";
    /**
     * Time in minutes for user to confirm his email
     */
    public final static int TOKEN_MINUTES_CONFIRMATION = 60;
}
