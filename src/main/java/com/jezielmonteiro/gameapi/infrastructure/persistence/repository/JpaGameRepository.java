package com.jezielmonteiro.gameapi.infrastructure.persistence.repository;

import com.jezielmonteiro.gameapi.domain.Game;
import com.jezielmonteiro.gameapi.domain.GameId;
import com.jezielmonteiro.gameapi.domain.GameRepository;
import com.jezielmonteiro.gameapi.infrastructure.persistence.entity.GameEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Repository
public class JpaGameRepository  implements GameRepository {

    private final GameCrudRepository repository;

    @Override
    public Game save(Game game) {
        var entity = toEntity(game);
        var saved = repository.save(entity);

        return toDomain(saved);
    }

    @Override
    public List<Game> findAll() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Optional<Game> findById(GameId id) {
        return repository.findById((id.id()))
                .map(this::toDomain);
    }

    @Override
    public void delete(GameId id) {
        repository.deleteById(id.id());
    }

    private GameEntity toEntity(Game game) {
        return new GameEntity(
                game.getId().id(),
                game.getTitle(),
                game.getGenre(),
                game.getDeveloper(),
                game.getReleaseYear()
        );
    }

    private Game toDomain(GameEntity entity) {
        return new Game(
                new GameId(entity.getId()),
                entity.getTitle(),
                entity.getGenre(),
                entity.getDeveloper(),
                entity.getReleaseYear()
        );
    }
}