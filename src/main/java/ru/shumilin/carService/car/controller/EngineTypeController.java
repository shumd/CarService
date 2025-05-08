package ru.shumilin.carService.car.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.car.entity.EngineTypeEntity;
import ru.shumilin.carService.car.service.EngineTypeService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/engine-types")
public class EngineTypeController{
    EngineTypeService engineTypeService;

    @PostMapping("/")
    public EngineTypeEntity createEngineType(@RequestParam String type){
        return engineTypeService.save(type);
    }

    @GetMapping("/all")
    public List<EngineTypeEntity> findAll(){
        return engineTypeService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        engineTypeService.delete(id);
    }

    @PutMapping("/{id}")
    public EngineTypeEntity update(@PathVariable int id, @RequestParam String type){
        return engineTypeService.update(id,type);
    }
}
