package com.cmaquera.kraken.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmaquera.kraken.payloads.ClientDTO;
import com.cmaquera.kraken.services.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/client")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<ClientDTO> saveClient(@Valid @RequestBody ClientDTO clientDto) {
        return new ResponseEntity<>(clientService.createClient(clientDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable(value = "id") Long clientId) {
        return ResponseEntity.ok(clientService.getClientById(clientId));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<ClientDTO>> getAllCategories() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable(value = "id") Long clientId,
                                                      @Valid @RequestBody ClientDTO clientDto) {
        return ResponseEntity.ok(clientService.updateClient(clientDto, clientId));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ObjectNode> deleteClient(@PathVariable(value = "id") Long clientId) {
        clientService.removeClient(clientId);
        ObjectMapper objectMapper = new ObjectMapper();
        var objectNode = objectMapper.createObjectNode();
        objectNode.put("message", "Client deleted successfully...");
        return ResponseEntity.ok(objectNode);
    }  
    
}
