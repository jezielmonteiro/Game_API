package com.jezielmonteiro.gameapi.application;

import com.jezielmonteiro.gameapi.application.input.UpdateGameInput;
import com.jezielmonteiro.gameapi.application.output.GameOutput;
import com.jezielmonteiro.gameapi.domain.GameId;
import com.jezielmonteiro.gameapi.domain.GameNotFoundException;
import com.jezielmonteiro.gameapi.domain.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpdateGameUseCase {

    private final GameRepository repository;

    public GameOutput execute(GameId id, UpdateGameInput input) {
        var game = repository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));

        game.update(
                input.title(),
                input.genre(),
                input.developer(),
                input.releaseYear()
        );

        var updated = repository.save(game);

        return GameOutput.from(updated);
    }
}