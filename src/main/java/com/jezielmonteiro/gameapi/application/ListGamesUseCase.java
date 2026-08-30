package com.jezielmonteiro.gameapi.application;

import java.util.List;
import com.jezielmonteiro.gameapi.application.output.GameOutput;
import com.jezielmonteiro.gameapi.domain.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class ListGamesUseCase {
    private final GameRepository repository;

    public ListGamesUseCase(GameRepository repository) {
        this.repository = repository;
    }
    public List execute() {
        return repository.findAll()
                .stream()
                .map(GameOutput::from)
                .toList();
    }
}