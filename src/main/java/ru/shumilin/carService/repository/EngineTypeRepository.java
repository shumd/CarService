package ru.shumilin.carService.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.entity.EngineTypeEntity;

public interface EngineTypeRepository extends CrudRepository<EngineTypeEntity, Integer> {
}
