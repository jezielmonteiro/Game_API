package com.jezielmonteiro.gameapi.application.input;

public record UpdateGameInput(
        String title,
        String developer,
        Integer releaseYear
) {
}