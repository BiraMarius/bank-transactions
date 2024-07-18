package com.example.banktransactions.oldApp.controller;

import com.example.banktransactions.oldApp.service.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create-new-client")
    public void createNewClient(@RequestParam String name){
        clientService.createNewClient(name);
    }

}
