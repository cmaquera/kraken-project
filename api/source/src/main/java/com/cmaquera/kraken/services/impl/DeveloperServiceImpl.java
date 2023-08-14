package com.cmaquera.kraken.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.configs.ModelMapperConfiguration;
import com.cmaquera.kraken.exceptions.ResourceNotFoundException;
import com.cmaquera.kraken.models.Developer;
import com.cmaquera.kraken.payloads.DeveloperDTO;
import com.cmaquera.kraken.repositories.AddressRepository;
import com.cmaquera.kraken.repositories.CredentialRepository;
import com.cmaquera.kraken.repositories.DeveloperRepository;
import com.cmaquera.kraken.services.DeveloperService;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DeveloperServiceImpl() {
        this.modelMapper = new ModelMapperConfiguration().getModelMapper();
    }

    @Override
    public DeveloperDTO createDeveloper(DeveloperDTO developerDTO) {
        final var credential = credentialRepository.findById(developerDTO.getCredentialId())
                .orElseThrow(() -> new ResourceNotFoundException("Credential", "id", developerDTO.getCredentialId()));

        final var address = addressRepository.findById(developerDTO.getAddressId())
                .orElseThrow(() -> new ResourceNotFoundException("Address", "id", developerDTO.getAddressId()));

        Developer developer = modelMapper.map(developerDTO, Developer.class);
        developer.setCredential(credential);
        developer.setAddress(address);

        final var savedDeveloper = developerRepository.save(developer);

        return modelMapper.map(savedDeveloper, DeveloperDTO.class);
    }

    @Override
    public DeveloperDTO getDeveloperById(Long id) {
        final var developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("developer", "id", id));
        
        return modelMapper.map(developer, DeveloperDTO.class);
    }

    @Override
    public List<DeveloperDTO> getAllDevelopers() {
        return developerRepository
                .findAll()
                .stream()
                .map(developer -> modelMapper.map(developer, DeveloperDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DeveloperDTO updateDeveloper(DeveloperDTO developerDTO, Long id) {
        final var credential = credentialRepository.findById(developerDTO.getCredentialId())
                .orElseThrow(() -> new ResourceNotFoundException("Credential", "id", developerDTO.getCredentialId()));

        final var address = addressRepository.findById(developerDTO.getAddressId())
                .orElseThrow(() -> new ResourceNotFoundException("Address", "id", developerDTO.getAddressId()));

        final var developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("developer", "id", id));
        
        developer.setTitle(developerDTO.getTitle());
        developer.setName(developerDTO.getName());
        developer.setLastname(developerDTO.getLastname());
        developer.setNikname(developerDTO.getNikname());
        developer.setShortDescription(developerDTO.getShortDescription());
        developer.setDescription(developerDTO.getDescription());
        developer.setId(developerDTO.getId());

        developer.setCredential(credential);
        developer.setAddress(address);

        final var updatedDeveloper = developerRepository.save(developer);

        return modelMapper.map(updatedDeveloper, DeveloperDTO.class);
    }

    @Override
    public void removeDeveloper(Long id) {
        final var developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("developer", "id", id));
        
        developerRepository.deleteById(developer.getId());
    }
    
}
