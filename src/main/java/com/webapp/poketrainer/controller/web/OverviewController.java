package com.webapp.poketrainer.controller.web;

import com.webapp.poketrainer.mapper.TrainerMapper;
import com.webapp.poketrainer.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class OverviewController {

    private final TrainerService trainerService;
    private final TrainerMapper trainerMapper;

    @GetMapping("/overview")
    public String getPage(Model model) {
        model.addAttribute("trainer",
                trainerMapper
                        .entityToDto(trainerService
                        .get(trainerService
                                .getLogged()
                                .getId())));
        return "overview";
    }
}
