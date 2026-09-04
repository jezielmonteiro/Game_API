package com.jezielmonteiro.gameapi.infrastructure.persistence.repository;

import com.jezielmonteiro.gameapi.infrastructure.persistence.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface GameCrudRepository
        extends CrudRepository<GameEntity, UUID> {
}