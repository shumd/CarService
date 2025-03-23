package ru.shumilin.carService.human.manager.controller;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.human.manager.entity.ManagerEntity;
import ru.shumilin.carService.human.manager.request.ManagerRequest;
import ru.shumilin.carService.human.manager.service.ManagerService;
import ru.shumilin.carService.human.name.entity.NameEntity;
import ru.shumilin.carService.human.name.service.NameService;
import ru.shumilin.carService.human.status.workStatus.service.WorkStatusService;

@RestController
@RequestMapping("/managers")
@CrossOrigin
@AllArgsConstructor
public class ManagerController {
    private ManagerService managerService;
    private NameService nameService;
    private WorkStatusService workStatusService;

    @GetMapping
    public ManagerEntity findById(@RequestParam long id){
        return  managerService.findById(id);
    }

    @PostMapping
    @Transactional
    public ManagerEntity create(@RequestBody ManagerRequest request){
        NameEntity nameEntity = NameEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .patronymic(request.getPatronymic())
                .build();

        ManagerEntity managerEntity = ManagerEntity.builder()
                .name(nameService.save(nameEntity))
                .login(request.getLogin())
                .password(request.getPassword())
                .salary(request.getSalary())
                .workStatus(workStatusService.findStatusByStatusName(request.getStatus()))
                .build();

        return managerService.save(managerEntity);
    }

    @GetMapping("/login")
    public boolean login(@RequestParam long id,
            @RequestParam String l,
            @RequestParam String p){
        return managerService.login(id,l,p);
    }
}
