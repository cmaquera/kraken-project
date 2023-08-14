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

import com.cmaquera.kraken.payloads.DeveloperDTO;
import com.cmaquera.kraken.services.DeveloperService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("api/developer")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<DeveloperDTO> create(@RequestBody DeveloperDTO developerDTO) {
        return new ResponseEntity<>(developerService.createDeveloper(developerDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<DeveloperDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(developerService.getDeveloperById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<DeveloperDTO>> getAll() {
        return new ResponseEntity<>(developerService.getAllDevelopers(), HttpStatus.OK);
    }

    @PutMapping(value = "/", consumes = "application/json")
    public ResponseEntity<DeveloperDTO> update(@RequestBody DeveloperDTO developerDTO, @PathVariable(name = "id") Long id) {        
        return new ResponseEntity<>(developerService.updateDeveloper(developerDTO, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ObjectNode> delete(Long id) throws JsonProcessingException {
        developerService.removeDeveloper(id);
        ObjectMapper objectMapper = new ObjectMapper();
        var objectNode = objectMapper.createObjectNode();
        objectNode.put("message", "Developer deleted successfully...");
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);
        return new ResponseEntity<>(objectNode, HttpStatus.OK);
    }

}
