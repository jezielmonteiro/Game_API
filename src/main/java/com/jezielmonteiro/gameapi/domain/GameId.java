package com.jezielmonteiro.gameapi.domain;

import org.springframework.util.Assert;
import java.util.UUID;

public record GameId(UUID id) {
    public GameId {
        Assert.notNull(id,
                "O identificador do jogo não pode ser nulo");
    }

    public GameId() {
        this(UUID.randomUUID());
    }
}