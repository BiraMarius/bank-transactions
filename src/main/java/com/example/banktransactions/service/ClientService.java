package com.example.banktransactions.service;

import com.example.banktransactions.entity.Client;
import com.example.banktransactions.exception.ClientNotFoundE;
import com.example.banktransactions.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    //TODO -1 JUnit Test for this method
    public Client clientFromOptional(Long clientId) throws RuntimeException{
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if(clientOpt.isPresent()){
            return clientOpt.get();
        }
        throw new ClientNotFoundE("Client not found.");
    }

    public void createNewClient(String name){
        clientRepository.save(new Client(name));
    }
}
