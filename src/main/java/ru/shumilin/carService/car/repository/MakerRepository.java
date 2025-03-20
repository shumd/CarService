package ru.shumilin.carService.car.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.car.entity.MakerEntity;

import java.util.Optional;

public interface MakerRepository extends CrudRepository<MakerEntity, Integer> {
    Optional<MakerEntity> findByName(String name);
}
