package ru.shumilin.carService.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.entity.MakerEntity;
import ru.shumilin.carService.exception.MakerNotFoundException;
import ru.shumilin.carService.repository.MakerRepository;

@AllArgsConstructor
@RequestMapping("/makers")
@RestController
public class MakerController {
    private MakerRepository makerRepository;

    @GetMapping
    public MakerEntity getMaker(@RequestParam Integer id){
        return makerRepository.findById(id).orElseThrow(() -> new MakerNotFoundException(
                "Производитель с id = " + id + " не найден"
        ));
    }

    @PostMapping()
    public ResponseEntity<?> createMaker(@RequestBody MakerEntity maker){
        try{
            makerRepository.save(maker);
            return ResponseEntity.ok("Производитель создан успешно");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Неудалось создать производителя");
        }
    }
}
