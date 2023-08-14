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

import com.cmaquera.kraken.payloads.AddressDTO;
import com.cmaquera.kraken.services.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/address")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<AddressDTO> saveAddress(@Valid @RequestBody AddressDTO addressDto) {
        return new ResponseEntity<>(addressService.createAddress(addressDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable(value = "id") Long addressId) {
        return ResponseEntity.ok(addressService.getAddressById(addressId));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable(value = "id") Long addressId,
                                                      @Valid @RequestBody AddressDTO addressDto) {
        return ResponseEntity.ok(addressService.updateAddress(addressDto, addressId));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ObjectNode> deleteAddress(@PathVariable(value = "id") Long addressId) {
        addressService.removeAddress(addressId);
        ObjectMapper objectMapper = new ObjectMapper();
        var objectNode = objectMapper.createObjectNode();
        objectNode.put("message", "Address deleted successfully...");
        return ResponseEntity.ok(objectNode);
    }  
    
}
