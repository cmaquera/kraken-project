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

import com.cmaquera.kraken.payloads.SocialLinkDTO;
import com.cmaquera.kraken.services.SocialLinkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/socialLink")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SocialLinkController {

    @Autowired
    private SocialLinkService socialLinkService;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<SocialLinkDTO> saveSocialLink(@Valid @RequestBody SocialLinkDTO socialLinkDto) {
        return new ResponseEntity<>(socialLinkService.createSocialLink(socialLinkDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<SocialLinkDTO> getSocialLinkById(@PathVariable(value = "id") Long socialLinkId) {
        return ResponseEntity.ok(socialLinkService.getSocialLinkById(socialLinkId));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<SocialLinkDTO>> getAllSocialLinks() {
        return ResponseEntity.ok(socialLinkService.getAllSocialLinks());
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<SocialLinkDTO> updateSocialLink(@PathVariable(value = "id") Long socialLinkId,
                                                      @Valid @RequestBody SocialLinkDTO socialLinkDto) {
        return ResponseEntity.ok(socialLinkService.updateSocialLink(socialLinkDto, socialLinkId));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ObjectNode> deleteSocialLink(@PathVariable(value = "id") Long socialLinkId) {
        socialLinkService.removeSocialLink(socialLinkId);
        ObjectMapper objectMapper = new ObjectMapper();
        var objectNode = objectMapper.createObjectNode();
        objectNode.put("message", "SocialLink deleted successfully...");
        return ResponseEntity.ok(objectNode);
    }  
    
}
