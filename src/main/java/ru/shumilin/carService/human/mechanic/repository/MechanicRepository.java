package ru.shumilin.carService.human.mechanic.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shumilin.carService.human.mechanic.entity.MechanicEntity;
import ru.shumilin.carService.human.name.entity.NameEntity;
import ru.shumilin.carService.human.status.workStatus.entity.WorkStatusEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface MechanicRepository extends CrudRepository<MechanicEntity, Long> {
    Optional<MechanicEntity> findByName(NameEntity name);
    List<MechanicEntity> findAllByWorkStatus(WorkStatusEntity workStatus);

    @Modifying
    @Query(value = "CALL update_mechanic_salary(:id, :amount)", nativeQuery = true)
    void updateMechanicSalary(int id, int amount);
}
