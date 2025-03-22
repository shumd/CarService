package ru.shumilin.carService.worker.status.workStatus.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.worker.status.workStatus.entity.WorkStatusEntity;

import java.util.Optional;

public interface WorkStatusRepository extends CrudRepository<WorkStatusEntity, Integer> {
    public Optional<WorkStatusEntity> findByStatus(String status);
}
