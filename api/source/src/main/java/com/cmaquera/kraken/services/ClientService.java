package com.cmaquera.kraken.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.models.Client;
import com.cmaquera.kraken.repositories.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService implements BaseService<Client> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client create(Client entity) {
        return clientRepository.save(entity);
    }

    @Override
    public Client retrieve(Long id) {
        return clientRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Client with id: " + id + ", not avaible")    
        );
    }

    @Override
    public Client update(Client entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
