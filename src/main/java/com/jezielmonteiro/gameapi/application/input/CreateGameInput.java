package com.jezielmonteiro.gameapi.application.input;

public record CreateGameInput (
    String title,
    String developer,
    Integer releaseYear
) {
}