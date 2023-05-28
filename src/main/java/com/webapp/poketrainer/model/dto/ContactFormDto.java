package com.webapp.poketrainer.model.dto;

import lombok.*;

@Getter
@Setter
public class ContactFormDto{
    private String email;
    private String subject;
    private String message;
}
