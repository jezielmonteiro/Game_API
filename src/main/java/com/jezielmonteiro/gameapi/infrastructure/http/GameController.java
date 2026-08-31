package com.jezielmonteiro.gameapi.infrastructure.http;

import com.jezielmonteiro.gameapi.application.*;
import com.jezielmonteiro.gameapi.domain.GameId;
import com.jezielmonteiro.gameapi.infrastructure.http.request.CreateGameRequest;
import com.jezielmonteiro.gameapi.infrastructure.http.request.UpdateGameRequest;
import com.jezielmonteiro.gameapi.infrastructure.http.response.GameResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {
    private final CreateGameUseCase createGameUseCase;
    private final ListGamesUseCase listGamesUseCase;
    private final GetGameByIdUseCase getGameByIdUseCase;
    private final UpdateGameUseCase updateGameUseCase;
    private final DeleteGameUseCase deleteGameUseCase;

    public GameController(
            CreateGameUseCase createGameUseCase,
            ListGamesUseCase listGamesUseCase,
            GetGameByIdUseCase getGameByIdUseCase,
            UpdateGameUseCase updateGameUseCase,
            DeleteGameUseCase deleteGameUseCase) {
        this.createGameUseCase = createGameUseCase;
        this.listGamesUseCase = listGamesUseCase;
        this.getGameByIdUseCase = getGameByIdUseCase;
        this.updateGameUseCase = updateGameUseCase;
        this.deleteGameUseCase = deleteGameUseCase;
    }

    @PostMapping
    public ResponseEntity create(
            @RequestBody @Valid CreateGameRequest request) {
        var input = request.toInput();
        var output = createGameUseCase.execute(input);
        var response = GameResponse.from(output);
        var location = URI.create("/games/" + output.id());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public List list() {
        return listGamesUseCase.execute()
                .stream()
                .map(GameResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public GameResponse getById(@PathVariable UUID id) {
        var output = getGameByIdUseCase.execute(new GameId(id));
        return GameResponse.from(output);
    }

    @PutMapping("/{id}")
    public GameResponse update(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateGameRequest request) {
        var output = updateGameUseCase.execute(
                new GameId(id),
                request.toInput()
        );
        return GameResponse.from(output);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        deleteGameUseCase.execute(new GameId(id));
        return ResponseEntity.noContent().build();
    }
}