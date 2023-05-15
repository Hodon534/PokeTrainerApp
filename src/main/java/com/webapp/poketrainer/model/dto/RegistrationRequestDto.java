package com.webapp.poketrainer.model.dto;

import com.webapp.poketrainer.model.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequestDto {
    private String username;
    private String email;
    private String password;
    private Gender gender;
}
