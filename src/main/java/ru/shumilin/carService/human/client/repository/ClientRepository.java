package ru.shumilin.carService.human.client.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.human.client.entity.ClientEntity;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {
    Optional<ClientEntity> findByPhoneNumber(String phoneNumber);
}
