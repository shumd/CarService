package ru.shumilin.carService.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.entity.CarEntity;

public interface CarRepository extends CrudRepository<CarEntity, Long> {
}
