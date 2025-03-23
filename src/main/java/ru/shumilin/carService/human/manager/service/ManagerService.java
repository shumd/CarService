package ru.shumilin.carService.human.manager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.human.manager.entity.ManagerEntity;
import ru.shumilin.carService.human.manager.exception.ManagerNotFoundException;
import ru.shumilin.carService.human.manager.repository.ManagerRepository;
import ru.shumilin.carService.human.status.workStatus.entity.WorkStatusEntity;
import ru.shumilin.carService.human.status.workStatus.service.WorkStatusService;

@Service
@AllArgsConstructor
public class ManagerService {
    private ManagerRepository repo;
    private WorkStatusService workStatusService;

    public ManagerEntity findById(long id){
        return repo.findById(id).orElseThrow(
                () -> new ManagerNotFoundException(
                        "Менеджер с id " + id + " не найден"
                )
        );
    }

    public ManagerEntity save(ManagerEntity entity){
        return repo.save(entity);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public boolean login(long id, String login, String password){
        ManagerEntity manager = findById(id);
        return manager.getLogin().equals(login) &&
                manager.getPassword().equals(password);
    }

    public WorkStatusEntity updateWorkStatus(long idManager, int idWorkStatus){
        ManagerEntity managerEntity = findById(idManager);
        WorkStatusEntity workStatusEntity = workStatusService.findWorkStatusById(idWorkStatus);
        managerEntity.setWorkStatus(workStatusEntity);
        return workStatusEntity;
    }
}
