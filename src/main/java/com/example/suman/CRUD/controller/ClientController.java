package com.example.suman.CRUD.controller;
import com.example.suman.CRUD.model.Client;
import com.example.suman.CRUD.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ClientController {
    private final ClientService clientService;
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }
    @GetMapping("/clients")
    public List<Client> clients(){
        return clientService.getAllClients();
    }

}
