package ru.shumilin.carService.car.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.car.entity.CarEntity;

import java.util.Optional;

public interface CarRepository extends CrudRepository<CarEntity, Long> {
    Optional<CarEntity> findByLicensePlate(String licensePlate);
}
