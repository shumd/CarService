package ru.shumilin.carService.car.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.car.service.MakerService;
import ru.shumilin.carService.car.entity.MakerEntity;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/makers")
@RestController
public class MakerController {
    private MakerService makerService;

    @GetMapping
    public MakerEntity getMaker(@RequestParam Integer id){
        return makerService.findById(id);
    }

    @GetMapping("/all")
    public List<MakerEntity> all(){
        return makerService.findAll();
    }

    @PostMapping("/")
    public MakerEntity createMaker(@RequestParam String name){
        return makerService.save(name);
    }

    @DeleteMapping("/")
    public void deleteMaker(@RequestParam Integer id){
        makerService.delete(id);
    }

    @PutMapping("/{id}")
    public MakerEntity updateMaker(@PathVariable Integer id, @RequestParam String name){
        return makerService.update(id, name);
    }
}
