package com.cmaquera.kraken.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.configs.ModelMapperConfiguration;
import com.cmaquera.kraken.exceptions.ResourceNotFoundException;
import com.cmaquera.kraken.models.Address;
import com.cmaquera.kraken.payloads.AddressDTO;
import com.cmaquera.kraken.repositories.AddressRepository;
import com.cmaquera.kraken.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AddressServiceImpl() {
        this.modelMapper = new ModelMapperConfiguration().getModelMapper();
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        final var savedAddress = addressRepository.save(modelMapper.map(addressDTO, Address.class));

        return modelMapper.map(savedAddress, AddressDTO.class);
    }

    @Override
    public AddressDTO getAddressById(Long id) {
        final var address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("address", "id", id));
        
        return modelMapper.map(address, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getAllAddresses() {
        return addressRepository
                .findAll()
                .stream()
                .map(address -> modelMapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO, Long id) {
        final var address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("address", "id", id));
        
        address.setCountry(addressDTO.getContry());
        address.setState(addressDTO.getState());
        address.setId(addressDTO.getId());
        final var updatedAddress = addressRepository.save(address);

        return modelMapper.map(updatedAddress, AddressDTO.class);
    }

    @Override
    public void removeAddress(Long id) {
        final var address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("address", "id", id));
        
        addressRepository.deleteById(address.getId());
    }
    
}
