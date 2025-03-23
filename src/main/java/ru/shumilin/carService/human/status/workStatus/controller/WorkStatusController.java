package ru.shumilin.carService.human.status.workStatus.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.human.status.workStatus.entity.WorkStatusEntity;
import ru.shumilin.carService.human.status.workStatus.service.WorkStatusService;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/workStatus")
public class WorkStatusController {
    private WorkStatusService workStatusService;

    @GetMapping
    public String getStatusById(@RequestParam Integer id) {return workStatusService.findWorkStatusById(id).getStatus();}
    @GetMapping("/name")
    public String getStatusByName(@RequestParam String name){return workStatusService.findStatusByStatusName(name).getStatus();}

    @PostMapping
    public boolean saveStatus(@RequestParam String status){
        return workStatusService.save(WorkStatusEntity.builder().status(status).build());
    }

    @DeleteMapping
    public boolean deleteStatus(@RequestParam Integer id){
        return workStatusService.delete(id);
    }
}
