package com.jezielmonteiro.gameapi.infrastructure.http.response;

import com.jezielmonteiro.gameapi.application.output.GameOutput;

public record GameResponse(
        String id,
        String title,
        String developer,
        Integer releaseYear
) {
    public static GameResponse from(GameOutput output) {
        return new GameResponse(
                output.id(),
                output.title(),
                output.developer(),
                output.releaseYear()
        );
    }
}