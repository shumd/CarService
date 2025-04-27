package ru.shumilin.carService.car.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.car.entity.EngineTypeEntity;
import ru.shumilin.carService.car.service.EngineTypeService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/engineTypes")
public class EngineTypeController{
    EngineTypeService engineTypeService;

    @PostMapping
    public ResponseEntity<?> createEngineType(@RequestBody EngineTypeEntity engineType){
        try{
            return ResponseEntity.ok(engineTypeService.save(engineType));
        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body("Не удалось создать тип двигателя");
        }
    }

    @GetMapping("/all")
    public List<EngineTypeEntity> findAll(){
        return engineTypeService.findAll();
    }
}
