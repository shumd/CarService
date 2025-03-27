package ru.shumilin.carService.human.client.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.human.client.entity.ClientEntity;
import ru.shumilin.carService.human.client.exception.ClientNotFoundException;
import ru.shumilin.carService.human.client.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ClientService {
    private final ClientRepository clientRepository;

    public List<ClientEntity> findAll(){
        List<ClientEntity> clientEntities = new ArrayList<>();
        clientRepository.findAll().forEach(clientEntities::add);
        return clientEntities;
    }

    public ClientEntity findById(int id){
        return clientRepository.findById(id).orElseThrow(
                () -> new ClientNotFoundException(
                        "Клиент с id " + id + " не найден"
                )
        );
    }
    public ClientEntity findByPhone(String phone){
        return clientRepository.findByPhoneNumber(phone).orElseThrow(
                () -> new ClientNotFoundException(
                        "Клиент с номер " + phone + " не найден"
                )
        );
    }
    public ClientEntity save(ClientEntity clientEntity){
        return clientRepository.save(clientEntity);
    }
}
