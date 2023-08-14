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

import com.cmaquera.kraken.payloads.TechnologyDTO;
import com.cmaquera.kraken.services.TechnologyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/technology")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<TechnologyDTO> saveTechnology(@Valid @RequestBody TechnologyDTO technologyDTO) {
        return new ResponseEntity<>(technologyService.createTechnology(technologyDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<TechnologyDTO> getTechnologyById(@PathVariable(value = "id") Long technologyId) {
        return ResponseEntity.ok(technologyService.getTechnologyById(technologyId));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<TechnologyDTO>> getAllTechnologies() {
        return ResponseEntity.ok(technologyService.getAllTechnologies());
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<TechnologyDTO> updateTechnology(@PathVariable(value = "id") Long technologyId,
                                                      @Valid @RequestBody TechnologyDTO technologyDTO) {
        return ResponseEntity.ok(technologyService.updateTechnology(technologyDTO, technologyId));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ObjectNode> deleteTechnology(@PathVariable(value = "id") Long technologyId) {
        technologyService.removeTechnology(technologyId);
        ObjectMapper objectMapper = new ObjectMapper();
        var objectNode = objectMapper.createObjectNode();
        objectNode.put("message", "Technology deleted successfully...");
        return ResponseEntity.ok(objectNode);
    }
    
    
    
}
