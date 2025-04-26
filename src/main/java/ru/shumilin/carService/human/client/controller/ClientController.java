package ru.shumilin.carService.human.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.human.client.entity.ClientEntity;
import ru.shumilin.carService.human.client.request.ClientRequest;
import ru.shumilin.carService.human.client.service.ClientService;
import ru.shumilin.carService.human.name.entity.NameEntity;
import ru.shumilin.carService.human.name.service.NameService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @PostMapping
    public ClientEntity saveClient(@RequestBody ClientRequest clientRequest) {
        return clientService.save(clientService.toEntity(clientRequest));
    }

    @DeleteMapping
    public boolean deleteClientById(@RequestParam int id) {
        return clientService.deleteById(id);
    }

    @GetMapping("/all")
    public List<ClientEntity> getAllClients() {
        return clientService.findAll();
    }
    @GetMapping("/phone")
    public ClientEntity getClientByPhoneNumber(@RequestParam String phone) {
        return clientService.findByPhone(phone);
    }
    @GetMapping("/id")
    public ClientEntity getClientById(@RequestParam int id) {
        return clientService.findById(id);
    }

    @GetMapping("/auth")
    public boolean auth(@RequestParam String phoneNumber, @RequestParam String password) {
        return clientService.login(phoneNumber, password);
    }
}
