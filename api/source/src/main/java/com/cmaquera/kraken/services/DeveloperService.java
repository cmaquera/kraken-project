package com.cmaquera.kraken.services;

import java.util.List;

import com.cmaquera.kraken.payloads.DeveloperDTO;

public interface DeveloperService {

    DeveloperDTO createDeveloper(DeveloperDTO developerDTO);

    DeveloperDTO getDeveloperById(Long id);

    List<DeveloperDTO> getAllDevelopers();

    DeveloperDTO updateDeveloper(DeveloperDTO developerDTO, Long id);
    
    void removeDeveloper(Long id);
    
}
