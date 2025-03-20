package ru.shumilin.carService.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.entity.EngineTypeEntity;

import java.util.Optional;

public interface EngineTypeRepository extends CrudRepository<EngineTypeEntity, Integer> {
    Optional<EngineTypeEntity> findByType(String type);
}
