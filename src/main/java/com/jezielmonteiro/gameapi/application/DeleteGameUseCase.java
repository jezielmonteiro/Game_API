package com.jezielmonteiro.gameapi.application;

import com.jezielmonteiro.gameapi.domain.GameId;
import com.jezielmonteiro.gameapi.domain.GameNotFoundException;
import com.jezielmonteiro.gameapi.domain.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteGameUseCase {
    private final GameRepository repository;

    public DeleteGameUseCase(GameRepository repository) {
        this.repository = repository;
    }

    public void execute(GameId gameId) {
        if (repository.findById(gameId).isEmpty()) {
            throw new GameNotFoundException(gameId);
        }
        repository.delete(gameId);
    }
}