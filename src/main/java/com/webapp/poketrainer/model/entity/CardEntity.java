package com.webapp.poketrainer.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "pokemon_cards")
public class CardEntity implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    private String id;
    private String name;
    @Column(name="Small Image")
    private String smallImage;
    @OneToOne(fetch = FetchType.EAGER)
    private TrainerEntity trainer;
    public CardEntity(
            String id,
            String name,
            String smallImage,
            TrainerEntity trainer)
    {
        this.id = id;
        this.name = name;
        this.smallImage = smallImage;
        this.trainer = trainer;
    }


}
