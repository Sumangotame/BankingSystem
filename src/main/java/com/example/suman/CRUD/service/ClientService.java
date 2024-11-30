package com.example.suman.CRUD.service;
import com.example.suman.CRUD.repo.ClientRepository;
import org.springframework.stereotype.Service;
import com.example.suman.CRUD.model.Client;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service
public class ClientService {
  private final ClientRepository clientRepository;
  public ClientService(ClientRepository clientRepository)
  {
      this.clientRepository=clientRepository;
  }
  @GetMapping("/clients")
public List<Client> getAllClients(){
      return clientRepository.findAll();
}
}
