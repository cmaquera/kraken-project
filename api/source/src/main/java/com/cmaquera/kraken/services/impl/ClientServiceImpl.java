package com.cmaquera.kraken.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.configs.ModelMapperConfiguration;
import com.cmaquera.kraken.exceptions.ResourceNotFoundException;
import com.cmaquera.kraken.models.Client;
import com.cmaquera.kraken.payloads.ClientDTO;
import com.cmaquera.kraken.repositories.ClientRepository;
import com.cmaquera.kraken.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ClientServiceImpl() {
        this.modelMapper = new ModelMapperConfiguration().getModelMapper();
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        final var savedClient = clientRepository.save(modelMapper.map(clientDTO, Client.class));
        
        return modelMapper.map(savedClient, ClientDTO.class);
    }

    @Override
    public ClientDTO getClientById(Long id) {
        final var client = clientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("client", "id", id));
    
        return modelMapper.map(client, ClientDTO.class);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository
                .findAll()
                .stream()
                .map(client -> modelMapper.map(client, ClientDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO, Long id) {
        final var client = clientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("client", "id", id));
        
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setDescription(clientDTO.getDescription());
        final var updatedClient = clientRepository.save(client);

        return modelMapper.map(updatedClient, ClientDTO.class);
    }

    @Override
    public void removeClient(Long id) {
        final var client = clientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("client", "id", id));
    
        clientRepository.deleteById(client.getId());
    }
}
