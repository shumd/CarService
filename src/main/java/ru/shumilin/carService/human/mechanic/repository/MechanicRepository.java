package ru.shumilin.carService.human.mechanic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.human.mechanic.entity.MechanicEntity;

public interface MechanicRepository extends CrudRepository<MechanicEntity, Long> {
//    Optional<MechanicEntity> findByName(String name);
}
