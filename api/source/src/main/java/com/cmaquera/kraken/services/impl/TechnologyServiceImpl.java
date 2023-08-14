package com.cmaquera.kraken.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.configs.ModelMapperConfiguration;
import com.cmaquera.kraken.exceptions.ResourceNotFoundException;
import com.cmaquera.kraken.models.Technology;
import com.cmaquera.kraken.payloads.TechnologyDTO;
import com.cmaquera.kraken.repositories.TechnologyRepository;
import com.cmaquera.kraken.services.TechnologyService;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TechnologyServiceImpl() {
        this.modelMapper = new ModelMapperConfiguration().getModelMapper();
    }

    @Override
    public TechnologyDTO createTechnology(TechnologyDTO technologyDTO) {
        final var savedTechnology = technologyRepository.save(modelMapper.map(technologyDTO, Technology.class));

        return modelMapper.map(savedTechnology, TechnologyDTO.class);
    }

    @Override
    public TechnologyDTO getTechnologyById(Long id) {
        final var technology = technologyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("technology", "id", id));
    
        return modelMapper.map(technology, TechnologyDTO.class);    
    }

    @Override
    public List<TechnologyDTO> getAllTechnologies() {
        return technologyRepository
                .findAll()
                .stream()
                .map(technology -> modelMapper.map(technology, TechnologyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TechnologyDTO updateTechnology(TechnologyDTO technologyDTO, Long id) {
        final var technology = technologyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("technology", "id", id));
        
        technology.setId(technologyDTO.getId());
        technology.setName(technologyDTO.getName());
        technology.setDescription(technologyDTO.getDescription());
        final var updatedTechnology = technologyRepository.save(technology);

        return modelMapper.map(updatedTechnology, TechnologyDTO.class);
    }

    @Override
    public void removeTechnology(Long id) {
        final var technology = technologyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("technology", "id", id));
    
        technologyRepository.deleteById(technology.getId());
    }
    
}
