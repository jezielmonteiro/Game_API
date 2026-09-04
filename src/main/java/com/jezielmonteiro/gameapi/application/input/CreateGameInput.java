package com.jezielmonteiro.gameapi.application.input;

public record CreateGameInput (
    String title,
    String genre,
    String developer,
    Integer releaseYear
) {
}