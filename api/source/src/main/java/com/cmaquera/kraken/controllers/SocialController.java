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

import com.cmaquera.kraken.payloads.SocialDTO;
import com.cmaquera.kraken.services.SocialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/social")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SocialController {

    @Autowired
    private SocialService socialService;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<SocialDTO> saveSocial(@Valid @RequestBody SocialDTO socialDto) {
        return new ResponseEntity<>(socialService.createSocial(socialDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<SocialDTO> getSocialById(@PathVariable(value = "id") Long socialId) {
        return ResponseEntity.ok(socialService.getSocialById(socialId));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<SocialDTO>> getAllSocials() {
        return ResponseEntity.ok(socialService.getAllSocials());
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<SocialDTO> updateSocial(@PathVariable(value = "id") Long socialId,
                                                      @Valid @RequestBody SocialDTO socialDto) {
        return ResponseEntity.ok(socialService.updateSocial(socialDto, socialId));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ObjectNode> deleteSocial(@PathVariable(value = "id") Long socialId) {
        socialService.removeSocial(socialId);
        ObjectMapper objectMapper = new ObjectMapper();
        var objectNode = objectMapper.createObjectNode();
        objectNode.put("message", "Social deleted successfully...");
        return ResponseEntity.ok(objectNode);
    }  
    
}
