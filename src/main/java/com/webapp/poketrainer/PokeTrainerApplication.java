package com.webapp.poketrainer;

import com.webapp.poketrainer.model.dto.ContactFormDto;
import com.webapp.poketrainer.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PokeTrainerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeTrainerApplication.class, args);
	}
}
