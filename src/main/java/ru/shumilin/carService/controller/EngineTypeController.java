package ru.shumilin.carService.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shumilin.carService.entity.EngineTypeEntity;
import ru.shumilin.carService.repository.EngineTypeRepository;
import ru.shumilin.carService.service.EngineTypeService;

@AllArgsConstructor
@RestController
@RequestMapping("/engineType")
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
}
