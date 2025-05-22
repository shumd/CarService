package ru.shumilin.carService.human.manager.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.shumilin.carService.human.manager.entity.ManagerEntity;

import java.util.Optional;

@Repository
public interface ManagerRepository extends CrudRepository<ManagerEntity, Long> {
    Optional<ManagerEntity> findByLogin(String login);

    @Modifying
    @Query(value = "CALL update_manager_salary(:id,:amount)", nativeQuery = true)
    void updateSalary(@Param("id") int id, @Param("amount") int amount);
}
