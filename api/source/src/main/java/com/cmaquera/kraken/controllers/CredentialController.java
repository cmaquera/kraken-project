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

import com.cmaquera.kraken.payloads.CredentialDTO;
import com.cmaquera.kraken.services.CredentialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/credential")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<CredentialDTO> saveCredential(@Valid @RequestBody CredentialDTO credentialDto) {
        return new ResponseEntity<>(credentialService.createCredential(credentialDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<CredentialDTO> getCredentialById(@PathVariable(value = "id") Long credentialId) {
        return ResponseEntity.ok(credentialService.getCredentialById(credentialId));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<CredentialDTO>> getAllCredentials() {
        return ResponseEntity.ok(credentialService.getAllCredentials());
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<CredentialDTO> updateCredential(@PathVariable(value = "id") Long credentialId,
                                                      @Valid @RequestBody CredentialDTO credentialDto) {
        return ResponseEntity.ok(credentialService.updateCredential(credentialDto, credentialId));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ObjectNode> deleteCredential(@PathVariable(value = "id") Long credentialId) {
        credentialService.removeCredential(credentialId);
        ObjectMapper objectMapper = new ObjectMapper();
        var objectNode = objectMapper.createObjectNode();
        objectNode.put("message", "Credential deleted successfully...");
        return ResponseEntity.ok(objectNode);
    }  
    
}
