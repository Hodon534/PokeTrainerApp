package com.webapp.poketrainer.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RegistrationRequestDto {
    @NotNull(message = "Username cannot be null")
    private String username;
    @Email(message = "Enter a proper email address")
    private String email;
    @Size(min = 8, max = 65, message = "password length has to be between 8 and 65 characters")
    private String password;
}
