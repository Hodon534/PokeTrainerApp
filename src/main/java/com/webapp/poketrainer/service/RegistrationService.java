package com.webapp.poketrainer.service;

import com.webapp.poketrainer.model.dto.RegistrationRequestDto;
import com.webapp.poketrainer.model.entity.UserEntity;
import com.webapp.poketrainer.model.enums.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String register(RegistrationRequestDto request) {
        userService.singUpUser(new UserEntity(
                request.getUsername(),
                request.getEmail(),
                bCryptPasswordEncoder.encode(request.getPassword()),
                UserRole.USER,
                request.getGender()
        ));
        return "register";
    }
}
