package ru.shumilin.carService.human.mechanic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shumilin.carService.human.mechanic.entity.MechanicEntity;
import ru.shumilin.carService.human.name.entity.NameEntity;

import java.util.Optional;

@Repository
public interface MechanicRepository extends CrudRepository<MechanicEntity, Long> {
    Optional<MechanicEntity> findByName(NameEntity name);
}
