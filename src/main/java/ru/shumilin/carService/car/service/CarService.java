package ru.shumilin.carService.car.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.car.entity.CarEntity;
import ru.shumilin.carService.car.exception.CarNotFoundException;
import ru.shumilin.carService.car.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private CarRepository carRepository;

    public boolean save(CarEntity carEntity) {
        carRepository.save(carEntity);
        return carRepository.existsById(carEntity.getId());
    }

    public boolean delete(Long id) {
        carRepository.deleteById(id);
        return !carRepository.existsById(id);
    }

    public CarEntity findById(Long id) {
        return carRepository.findById(id).
                orElseThrow(
                        () -> new CarNotFoundException(
                                "Автомобиль с id " + id + " не найден"
                        )
                );
    }

    public CarEntity findByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate).
                orElseThrow(
                        () -> new CarNotFoundException(
                                "Автомобиль с номером " + licensePlate + " не найден"
                        )
                );
    }

    public List<CarEntity> findAll(){
        List<CarEntity> res = new ArrayList<>();
        carRepository.findAll().forEach(res::add);
        return res;
    }
}
