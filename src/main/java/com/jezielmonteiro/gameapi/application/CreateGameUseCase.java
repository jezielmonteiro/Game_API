package com.jezielmonteiro.gameapi.application;

import com.jezielmonteiro.gameapi.application.input.CreateGameInput;
import com.jezielmonteiro.gameapi.application.output.GameOutput;
import com.jezielmonteiro.gameapi.domain.Game;
import com.jezielmonteiro.gameapi.domain.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateGameUseCase {
    private final GameRepository repository;
    public CreateGameUseCase(GameRepository repository) {
        this.repository = repository;
    }
    public GameOutput execute(CreateGameInput input) {
        var game = new Game(
                input.title(),
                input.developer(),
                input.releaseYear()
        );
        var saved = repository.save(game);
        return GameOutput.from(saved);
    }
}