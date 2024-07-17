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

    public Client clientFromOptional(Long clientId) throws RuntimeException{
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if(clientOpt.isPresent()){
            Client client = clientOpt.get();
            return client;
        } else {
            throw new ClientNotFoundE("Client not found.");
        }
    }
}
