package com.jezielmonteiro.gameapi.application;

import com.jezielmonteiro.gameapi.application.output.GameOutput;
import com.jezielmonteiro.gameapi.domain.GameId;
import com.jezielmonteiro.gameapi.domain.GameNotFoundException;
import com.jezielmonteiro.gameapi.domain.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GetGameByIdUseCase {
    private final GameRepository repository;

    public GetGameByIdUseCase(GameRepository repository) {
        this.repository = repository;
    }
    public GameOutput execute(GameId id) {
        return repository.findById(id)
                .map(GameOutput::from)
                .orElseThrow(() -> new GameNotFoundException(id));
    }
}