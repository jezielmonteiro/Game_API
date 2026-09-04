package com.jezielmonteiro.gameapi.domain;

import lombok.Getter;
import org.springframework.util.Assert;
import java.time.Year;

@Getter
public class Game {
    private final GameId id;
    private String title;
    private String genre;
    private String developer;
    private Integer releaseYear;

    public Game(String title, String genre, String developer, Integer releaseYear) {
        validate(title, genre, developer, releaseYear);
        this.id = new GameId();
        this.title = title;
        this.genre = genre;
        this.developer = developer;
        this.releaseYear = releaseYear;
    }

    public Game(GameId id, String title, String genre, String developer,
                Integer releaseYear) {
        Assert.notNull(id,
                "O identificador do livro não pode ser nulo");
        validate(title, genre, developer, releaseYear);

        this.id = id;
        this.title = title;
        this.genre = genre;
        this.developer = developer;
        this.releaseYear = releaseYear;
    }

    public void update(String title, String genre, String developer, Integer releaseYear) {
        validate(title, genre, developer, releaseYear);

        this.title = title;
        this.genre = genre;
        this.developer = developer;
        this.releaseYear = releaseYear;
    }

    private static void validate(String title, String genre, String developer,
                                 Integer releaseYear) {
        Assert.hasText(title, "O título não pode estar vazio");
        Assert.isTrue(title.length() >= 3 && title.length() <= 150,
                "O título deve possuir entre 3 e 150 caracteres");

        Assert.hasText(genre, "O gênero não pode estar vazio");
        Assert.isTrue(genre.length() >= 5 && genre.length() <= 50,
                "O gênero deve possuir entre 5 e 50 caracteres");

        Assert.hasText(developer, "O nome do estúdio desenvolvedor não pode estar vazio");
        Assert.isTrue(developer.length() >= 3 && developer.length() <= 100,
                "O nome do estúdio desenvolvedor deve possuir entre 3 e 100 caracteres");

        Assert.notNull(releaseYear,
                "O ano de lançamento não pode ser nulo");
        Assert.isTrue(releaseYear > 0,
                "O ano de lançamento deve ser positivo");

        Assert.isTrue(releaseYear <= Year.now().getValue(),
                "O ano de lançamento não pode ser maior que o ano atual");
    }
}