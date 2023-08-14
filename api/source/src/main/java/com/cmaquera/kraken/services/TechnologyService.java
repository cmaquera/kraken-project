package com.cmaquera.kraken.services;

import java.util.List;

import com.cmaquera.kraken.payloads.TechnologyDTO;

public interface TechnologyService {
    TechnologyDTO createTechnology(TechnologyDTO technologyDTO);

    TechnologyDTO getTechnologyById(Long id);

    List<TechnologyDTO> getAllTechnologies();

    TechnologyDTO updateTechnology(TechnologyDTO technologyDTO, Long id);
    
    void removeTechnology(Long id);
}
