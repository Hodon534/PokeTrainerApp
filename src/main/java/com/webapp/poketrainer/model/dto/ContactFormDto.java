package com.webapp.poketrainer.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
public class ContactFormDto{
    @Email(message = "Enter a proper email address")
    private String email;
    @NotNull(message = "Subject cannot be null")
    private String subject;
    @NotNull(message = "Message cannot be null")
    private String message;
}
