package ru.shumilin.carService.human.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shumilin.carService.human.manager.entity.ManagerEntity;

import java.util.Optional;

@Repository
public interface ManagerRepository extends CrudRepository<ManagerEntity, Long> {
    Optional<ManagerEntity> findByLogin(String login);
}
