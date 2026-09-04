package com.jezielmonteiro.gameapi.application;

import java.util.List;
import com.jezielmonteiro.gameapi.application.output.GameOutput;
import com.jezielmonteiro.gameapi.domain.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ListGamesUseCase {
    private final GameRepository repository;

    public List<GameOutput> execute() {
        return repository.findAll()
                .stream()
                .map(GameOutput::from)
                .toList();
    }
}