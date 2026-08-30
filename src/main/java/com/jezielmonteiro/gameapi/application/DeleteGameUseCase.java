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
    public void execute(GameId id) {
        if (repository.findById(id).isEmpty()) {
            throw new GameNotFoundException(id);
        }
        repository.delete(id);
    }
}