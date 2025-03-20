package ru.shumilin.carService.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.entity.MakerEntity;

public interface MakerRepository extends CrudRepository<MakerEntity, Integer> {
}
