package ru.shumilin.carService.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.entity.CarEntity;

import java.util.Optional;

public interface CarRepository extends CrudRepository<CarEntity, Long> {
    Optional<CarEntity> findByLicensePlate(String licensePlate);
}
