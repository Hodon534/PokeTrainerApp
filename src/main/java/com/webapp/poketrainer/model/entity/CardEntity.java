package com.webapp.poketrainer.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "pokemon_cards")
public class CardEntity implements Serializable {
    @Id
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(name="small_image", nullable = false)
    private String smallImage;
    public CardEntity(
            String id,
            String name,
            String smallImage)
    {
        this.id = id;
        this.name = name;
        this.smallImage = smallImage;
    }
    }
