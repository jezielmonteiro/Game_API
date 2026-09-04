package com.jezielmonteiro.gameapi.application.input;

public record UpdateGameInput(
        String title,
        String genre,
        String developer,
        Integer releaseYear
) {
}