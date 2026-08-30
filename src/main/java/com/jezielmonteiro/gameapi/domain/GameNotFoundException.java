package com.jezielmonteiro.gameapi.domain;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(GameId gameId) {
        super("Jogo com identificador "
                + gameId.id()
                + " não encontrado");
    }
}