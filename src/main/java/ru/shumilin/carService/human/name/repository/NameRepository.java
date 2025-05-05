package ru.shumilin.carService.human.name.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.human.name.entity.NameEntity;

import java.util.Optional;

public interface NameRepository extends CrudRepository<NameEntity, Long> {
    Optional<Iterable<NameEntity>> findBySurname(String surname);
    boolean existsByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);
}
