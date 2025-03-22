package ru.shumilin.carService.worker.mechanic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.worker.mechanic.entity.MechanicEntity;

import java.util.Optional;

public interface MechanicRepository extends CrudRepository<MechanicEntity, Long> {
//    Optional<MechanicEntity> findByName(String name);
}
