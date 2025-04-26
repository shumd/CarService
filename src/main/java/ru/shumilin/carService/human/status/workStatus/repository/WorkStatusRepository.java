package ru.shumilin.carService.human.status.workStatus.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.human.status.workStatus.entity.WorkStatusEntity;

import java.util.Optional;

public interface WorkStatusRepository extends CrudRepository<WorkStatusEntity, Integer> {
    Optional<WorkStatusEntity> findByStatus(String status);
    boolean existsByStatus(String status);
}
