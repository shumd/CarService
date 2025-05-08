package ru.shumilin.carService.human.manager.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.human.manager.entity.ManagerEntity;
import ru.shumilin.carService.human.manager.request.ManagerRequest;
import ru.shumilin.carService.human.manager.service.ManagerService;
import ru.shumilin.carService.human.name.entity.NameEntity;
import ru.shumilin.carService.human.name.service.NameService;
import ru.shumilin.carService.human.status.workStatus.service.WorkStatusService;

import java.util.List;

@RestController
@RequestMapping("/managers")
@CrossOrigin
@AllArgsConstructor
public class ManagerController {
    private ManagerService managerService;
    private NameService nameService;
    private WorkStatusService workStatusService;

    @GetMapping("/{id}")
    public ManagerEntity findById(@PathVariable long id){
        return  managerService.findById(id);
    }

    @GetMapping("/all")
    public List<ManagerEntity> findAll(){
        return managerService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        managerService.deleteById(id);
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
    public boolean login(@RequestParam String l,
                         @RequestParam String p,
                         HttpSession session){
        return managerService.login(l,p, session);
    }

    @GetMapping("/admin-profile")
    public String adminProfile(HttpSession session){
        String admin = (String) session.getAttribute("admin");
        if(admin == null){throw new RuntimeException("session is empty");}
        return admin;
    }
    @GetMapping("/profile")
    public ManagerEntity profile(HttpSession session){
        ManagerEntity manager = (ManagerEntity) session.getAttribute("manager");
        if (manager == null) {throw new RuntimeException("session is empty");}
        return manager;
    }
    @PostMapping("/logout")
    public void logout(HttpSession session){
        session.removeAttribute("manager");
    }
    @PostMapping("/admin-logout")
    public void adminLogout(HttpSession session){
        session.removeAttribute("admin");
    }
}
