package com.cmaquera.kraken.services;

import java.util.List;

import com.cmaquera.kraken.payloads.ClientDTO;

public interface ClientService {

    ClientDTO createClient(ClientDTO clientDTO);

    ClientDTO getClientById(Long id);

    List<ClientDTO> getAllClients();

    ClientDTO updateClient(ClientDTO clientDTO, Long id);
    
    void removeClient(Long id);
    
}
