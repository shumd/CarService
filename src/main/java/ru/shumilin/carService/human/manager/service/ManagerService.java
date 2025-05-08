package ru.shumilin.carService.human.manager.service;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.human.manager.entity.ManagerEntity;
import ru.shumilin.carService.human.manager.exception.ManagerNotFoundException;
import ru.shumilin.carService.human.manager.repository.ManagerRepository;
import ru.shumilin.carService.human.status.workStatus.entity.WorkStatusEntity;
import ru.shumilin.carService.human.status.workStatus.service.WorkStatusService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {
    @Value("${admin.login}")
    private String adminLogin;
    @Value("${admin.password}")
    private String adminPassword;

    private final ManagerRepository repo;
    private final WorkStatusService workStatusService;


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

    public boolean login(String login, String password, HttpSession session){
        if(isAdmin(login, password)){
            session.setAttribute("admin", login);
            return true;
        }


        ManagerEntity manager = repo.findByLogin(login).orElseThrow(
                () -> new ManagerNotFoundException(
                        "Менеджер с логином " + login + " не найден"
                )
        );

        if(manager.getLogin().equals(login) && manager.getPassword().equals(password)){
            session.setAttribute("manager", manager);
            return true;
        }
        return false;
    }

    public boolean isAdmin(String login, String password){
        return login.equals(adminLogin) && password.equals(adminPassword);
    }

    public WorkStatusEntity updateWorkStatus(long idManager, int idWorkStatus){
        ManagerEntity managerEntity = findById(idManager);
        WorkStatusEntity workStatusEntity = workStatusService.findWorkStatusById(idWorkStatus);
        managerEntity.setWorkStatus(workStatusEntity);
        return workStatusEntity;
    }

    public List<ManagerEntity> findAll() {
        List<ManagerEntity> res = new ArrayList<>();
        repo.findAll().forEach(res::add);
        return res;
    }


}
