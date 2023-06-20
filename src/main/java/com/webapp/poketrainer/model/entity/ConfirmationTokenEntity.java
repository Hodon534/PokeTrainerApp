package com.webapp.poketrainer.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="tokens")
public class ConfirmationTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;
    @Column(nullable = false, name = "expires_at")
    private LocalDateTime expiresAt;
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;
    @ManyToOne
    private UserEntity user;

    public ConfirmationTokenEntity(String token, LocalDateTime createdAt, LocalDateTime expiresAt, UserEntity user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }

}
