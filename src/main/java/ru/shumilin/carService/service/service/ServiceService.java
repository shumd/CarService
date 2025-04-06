package ru.shumilin.carService.service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.service.entity.ServiceEntity;
import ru.shumilin.carService.service.exception.ServiceNotFoundException;
import ru.shumilin.carService.service.repository.ServiceRepository;

@Service
@AllArgsConstructor
public class ServiceService {
    private ServiceRepository serviceRepository;

    public ServiceEntity findById(int id){
        return serviceRepository.findById(id).orElseThrow(
                () -> new ServiceNotFoundException(
                        "Сервис с id " + id + " не найден"
                )
        );
    }

    public ServiceEntity findByName(String name){
        return serviceRepository.findByName(name).orElseThrow(
                () -> new ServiceNotFoundException(
                        "Сервис с именем " + name + " не найден"
                )
        );
    }

    public ServiceEntity save(ServiceEntity serviceEntity){
        return serviceRepository.save(serviceEntity);
    }

    public boolean deleteById(int id) {
        serviceRepository.deleteById(id);
        return !serviceRepository.existsById(id);
    }
}
