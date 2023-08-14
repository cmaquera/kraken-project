package com.cmaquera.kraken.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.configs.ModelMapperConfiguration;
import com.cmaquera.kraken.exceptions.ResourceNotFoundException;
import com.cmaquera.kraken.models.Credential;
import com.cmaquera.kraken.payloads.CredentialDTO;
import com.cmaquera.kraken.repositories.CredentialRepository;
import com.cmaquera.kraken.services.CredentialService;

@Service
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CredentialServiceImpl() {
        this.modelMapper = new ModelMapperConfiguration().getModelMapper();
    }

    @Override
    public CredentialDTO createCredential(CredentialDTO credentialDTO) {
        final var savedCredential = credentialRepository.save(modelMapper.map(credentialDTO, Credential.class));

        return modelMapper.map(savedCredential, CredentialDTO.class);
    }

    @Override
    public CredentialDTO getCredentialById(Long id) {
        final var credential = credentialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("credential", "id", id));
        
        return modelMapper.map(credential, CredentialDTO.class);
    }

    @Override
    public List<CredentialDTO> getAllCredentials() {
        return credentialRepository
                .findAll()
                .stream()
                .map(credential -> modelMapper.map(credential, CredentialDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CredentialDTO updateCredential(CredentialDTO credentialDTO, Long id) {
        final var credential = credentialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("credential", "id", id));
        
        credential.setUsername(credentialDTO.getUsername());
        credential.setPassword(credentialDTO.getPassword());
        credential.setId(credentialDTO.getId());
        final var updatedCredential = credentialRepository.save(credential);

        return modelMapper.map(updatedCredential, CredentialDTO.class);
    }

    @Override
    public void removeCredential(Long id) {
        final var credential = credentialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("credential", "id", id));
        
        credentialRepository.deleteById(credential.getId());
    }
    
}
