package ru.shumilin.carService.car.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.car.service.MakerService;
import ru.shumilin.carService.car.entity.MakerEntity;

@AllArgsConstructor
@RequestMapping("/makers")
@RestController
public class MakerController {
    private MakerService makerService;

    @GetMapping
    public MakerEntity getMaker(@RequestParam Integer id){
        return makerService.findById(id);
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
