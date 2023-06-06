package com.webapp.poketrainer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardDto {
    private String id;
    private String name;
    private String smallImage;
    private Long trainerId;
}
