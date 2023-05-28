package com.webapp.poketrainer.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RegistrationRequestDto {
    private String username;
    private String email;
    private String password;
}
