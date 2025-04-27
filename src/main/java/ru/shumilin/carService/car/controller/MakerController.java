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

    @PostMapping()
    public ResponseEntity<?> createMaker(@RequestBody MakerEntity maker){
        try{
            makerService.save(maker);
            return ResponseEntity.ok("Производитель создан успешно");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Не удалось создать производителя");
        }
    }
}
