package com.cmaquera.kraken.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.configs.ModelMapperConfiguration;
import com.cmaquera.kraken.exceptions.ResourceNotFoundException;
import com.cmaquera.kraken.models.Social;
import com.cmaquera.kraken.payloads.SocialDTO;
import com.cmaquera.kraken.repositories.SocialRepository;
import com.cmaquera.kraken.services.SocialService;

@Service
public class SocialServiceImpl implements SocialService {

    @Autowired
    private SocialRepository socialRepository;

    @Autowired
    private ModelMapper modelMapper;

    public SocialServiceImpl() {
        this.modelMapper = new ModelMapperConfiguration().getModelMapper();
    }

    @Override
    public SocialDTO createSocial(SocialDTO socialDTO) {
        final var savedSocial = socialRepository.save(modelMapper.map(socialDTO, Social.class));

        return modelMapper.map(savedSocial, SocialDTO.class);
    }

    @Override
    public SocialDTO getSocialById(Long id) {
        final var social = socialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("social", "id", id));
        
        return modelMapper.map(social, SocialDTO.class);
    }

    @Override
    public List<SocialDTO> getAllSocials() {
        return socialRepository
                .findAll()
                .stream()
                .map(social -> modelMapper.map(social, SocialDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SocialDTO updateSocial(SocialDTO socialDTO, Long id) {
        final var social = socialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("social", "id", id));
        
        social.setName(socialDTO.getName());
        social.setId(socialDTO.getId());
        final var updatedSocial = socialRepository.save(social);

        return modelMapper.map(updatedSocial, SocialDTO.class);
    }

    @Override
    public void removeSocial(Long id) {
        final var social = socialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("social", "id", id));
        
        socialRepository.deleteById(social.getId());
    }
    
}
