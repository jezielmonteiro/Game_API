package com.jezielmonteiro.gameapi.domain;

import java.util.List;
import java.util.Optional;

public interface GameRepository {

    Game save(Game game);

    List<Game> findAll();

    Optional<Game> findById(GameId id);

    void delete(GameId id);
}