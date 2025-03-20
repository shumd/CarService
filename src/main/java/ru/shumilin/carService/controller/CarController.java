package ru.shumilin.carService.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.entity.CarEntity;
import ru.shumilin.carService.entity.EngineTypeEntity;
import ru.shumilin.carService.entity.MakerEntity;
import ru.shumilin.carService.exception.CarNotFoundException;
import ru.shumilin.carService.exception.EngineTypeNotFoundException;
import ru.shumilin.carService.exception.MakerNotFoundException;
import ru.shumilin.carService.repository.CarRepository;
import ru.shumilin.carService.repository.EngineTypeRepository;
import ru.shumilin.carService.repository.MakerRepository;
import ru.shumilin.carService.request.CarRequest;
import ru.shumilin.carService.service.CarService;
import ru.shumilin.carService.service.EngineTypeService;
import ru.shumilin.carService.service.MakerService;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {
    private CarService carService;
    private MakerService makerService;
    private EngineTypeService engineTypeService;

    @GetMapping
    public CarEntity getCar(@RequestParam Long id){
        return carService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody CarRequest carRequest){
        try{
            EngineTypeEntity engineType = engineTypeService.findByType(carRequest.getEngineType());
            MakerEntity makerEntity = makerService.findByName(carRequest.getMaker());

            CarEntity carEntity = CarEntity.builder()
                    .maker(makerEntity)
                    .model(carRequest.getModel())
                    .odometer(carRequest.getOdometer())
                    .licensePlate(carRequest.getLicensePlate())
                    .engineType(engineType)
                    .build();

            return ResponseEntity.ok(carService.save(carEntity));
        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body("Не удалось создать автомобиль");
        }
    }
}
