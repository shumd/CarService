package ru.shumilin.carService.car.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.car.entity.EngineTypeEntity;

import java.util.Optional;

public interface EngineTypeRepository extends CrudRepository<EngineTypeEntity, Integer> {
    Optional<EngineTypeEntity> findByType(String type);
}
