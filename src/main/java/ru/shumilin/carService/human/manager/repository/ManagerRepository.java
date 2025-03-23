package ru.shumilin.carService.human.manager.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.human.manager.entity.ManagerEntity;

public interface ManagerRepository extends CrudRepository<ManagerEntity, Long> {
}
