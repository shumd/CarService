package ru.shumilin.carService.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shumilin.carService.service.entity.ServiceEntity;

import java.util.Optional;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity, Integer> {
    Optional<ServiceEntity> findByName(String name);
}
