package ru.shumilin.carService.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.entity.CarEntity;
import ru.shumilin.carService.entity.EngineTypeEntity;
import ru.shumilin.carService.entity.MakerEntity;
import ru.shumilin.carService.exception.CarNotFoundException;
import ru.shumilin.carService.exception.EngineNotFoundException;
import ru.shumilin.carService.exception.MakerNotFoundException;
import ru.shumilin.carService.repository.CarRepository;
import ru.shumilin.carService.repository.EngineTypeRepository;
import ru.shumilin.carService.repository.MakerRepository;
import ru.shumilin.carService.request.CarRequest;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {
    private CarRepository carRepository;
    private MakerRepository makerRepository;
    private EngineTypeRepository engineTypeRepository;

    @GetMapping
    public CarEntity getCar(@RequestParam Long id){
        return carRepository.findById(id).
                orElseThrow(() -> new CarNotFoundException(
                        "Автомобиль с id = " + id + " не найден"));
    }

    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody CarRequest carRequest){
        try{
            EngineTypeEntity engineType = engineTypeRepository.
                    findById(carRequest.getEngineId()).
                    orElseThrow(() -> new EngineNotFoundException(
                            "Двигатель с id = " + carRequest.getEngineId()
                            + " не найден"
                    ));
            MakerEntity makerEntity = makerRepository.
                    findById(carRequest.getMakerId()).orElseThrow(
                            () -> new MakerNotFoundException(
                                    "Производитель не найден с id = "+
                                            carRequest.getMakerId()
                                    + " не найден"
                            )
                    );

            CarEntity carEntity = CarEntity.builder()
                    .maker(makerEntity)
                    .model(carRequest.getModel())
                    .odometer(carRequest.getOdometer())
                    .licensePlate(carRequest.getLicensePlate())
                    .engineType(engineType)
                    .build();

            return ResponseEntity.ok(carRepository.save(carEntity));
        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body("Не удалось создать автомобиль");
        }
    }
}
