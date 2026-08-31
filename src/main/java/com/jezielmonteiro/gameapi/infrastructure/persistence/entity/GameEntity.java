package com.jezielmonteiro.gameapi.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "games")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameEntity {
    @Id
    private UUID id;
    @Column(nullable = false, length = 150)
    private String title;
    @Column(nullable = false, length = 100)
    private String developer;
    @Column(nullable = false)
    private Integer releaseYear;
    public GameEntity(UUID id, String title, String developer,
                      Integer releaseYear) {
        this.id = id;
        this.title = title;
        this.developer = developer;
        this.releaseYear = releaseYear;
    }
}