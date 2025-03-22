package ru.shumilin.carService.car.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.car.entity.CarEntity;
import ru.shumilin.carService.car.entity.EngineTypeEntity;
import ru.shumilin.carService.car.entity.MakerEntity;
import ru.shumilin.carService.car.request.CarRequest;
import ru.shumilin.carService.car.service.CarService;
import ru.shumilin.carService.car.service.EngineTypeService;
import ru.shumilin.carService.car.service.MakerService;

import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin
@AllArgsConstructor
public class CarController {
    private CarService carService;
    private MakerService makerService;
    private EngineTypeService engineTypeService;

    @GetMapping()
    public CarEntity getCar(@RequestParam Long id){
        return carService.findById(id);
    }
    @GetMapping("/lp")
    public CarEntity getCar(@RequestParam String plate){
        return carService.findByLicensePlate(plate);
    }
    @GetMapping("/all")
    public List<CarEntity> findAllCars(){
        return carService.findAll();
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
                    .body("Не удалось создать автомобиль: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCar(@RequestParam Long id){
        try{
            return ResponseEntity.ok(carService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body("Не удалось удалить автомобиль");
        }
    }
}
