package ru.shumilin.carService.worker.name.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.worker.name.entity.NameEntity;

import java.util.Optional;

public interface NameRepository extends CrudRepository<NameEntity, Long> {
    Optional<Iterable<NameEntity>> findBySurname(String surname);
}
