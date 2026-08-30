package com.jezielmonteiro.gameapi.application.output;

import com.jezielmonteiro.gameapi.domain.Game;

public record GameOutput(
        String id,
        String title,
        String developer,
        Integer releaseYear
) {
    public static GameOutput from(Game game) {
        return new GameOutput(
                game.getId().id().toString(),
                game.getTitle(),
                game.getDeveloper(),
                game.getReleaseYear()
        );
    }
}