package ru.shumilin.carService.human.status.workStatus.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.human.status.workStatus.entity.WorkStatusEntity;
import ru.shumilin.carService.human.status.workStatus.exception.WorkStatusNotFoundException;
import ru.shumilin.carService.human.status.workStatus.repository.WorkStatusRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WorkStatusService {
    WorkStatusRepository workStatusRepository;

    public WorkStatusEntity findWorkStatusById(int id) {
        return workStatusRepository.findById(id).orElseThrow(() -> new WorkStatusNotFoundException(
                "Статус работы с id " + id + " не найден"
        ));
    }
    public WorkStatusEntity findStatusByStatusName(String statusName) {
        return workStatusRepository.findByStatus(statusName).orElseThrow(
                () -> new WorkStatusNotFoundException(
                        "Статус работы с именем " + statusName + " не найден"
                ));
    }
    public List<WorkStatusEntity> findAll() {
        List<WorkStatusEntity> res = new ArrayList<>();
        workStatusRepository.findAll().forEach(res::add);
        return res;
    }

    public boolean save(WorkStatusEntity workStatusEntity) {
        workStatusRepository.save(workStatusEntity);
        return workStatusRepository.existsById(workStatusEntity.getId());
    }
    public boolean delete(Integer id){
        workStatusRepository.deleteById(id);
        return !workStatusRepository.existsById(id);
    }

    public boolean existByStatus(String status){
        return workStatusRepository.existsByStatus(status);
    }
}
