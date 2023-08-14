package com.cmaquera.kraken.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.configs.ModelMapperConfiguration;
import com.cmaquera.kraken.exceptions.ResourceNotFoundException;
import com.cmaquera.kraken.models.SocialLink;
import com.cmaquera.kraken.payloads.SocialLinkDTO;
import com.cmaquera.kraken.repositories.DeveloperRepository;
import com.cmaquera.kraken.repositories.SocialLinkRepository;
import com.cmaquera.kraken.repositories.SocialRepository;
import com.cmaquera.kraken.services.SocialLinkService;

@Service
public class SocialLinkServiceImpl implements SocialLinkService {

    @Autowired
    private SocialLinkRepository socialLinkRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private SocialRepository socialRepository;

    @Autowired
    private ModelMapper modelMapper;

    public SocialLinkServiceImpl() {
        this.modelMapper = new ModelMapperConfiguration().getModelMapper();
    }

    @Override
    public SocialLinkDTO createSocialLink(SocialLinkDTO socialLinkDTO) {
        final var developer = developerRepository.findById(socialLinkDTO.getDeveloperId())
                .orElseThrow(() -> new ResourceNotFoundException("Developer", "id", socialLinkDTO.getDeveloperId()));
        
        final var social = socialRepository.findById(socialLinkDTO.getSocialId())
                .orElseThrow(() -> new ResourceNotFoundException("Social", "id", socialLinkDTO.getSocialId()));

        SocialLink socialLink = modelMapper.map(socialLinkDTO, SocialLink.class);
        socialLink.setDeveloper(developer);
        socialLink.setSocial(social);

        SocialLink savedSocialLink = socialLinkRepository.save(socialLink);

        return modelMapper.map(savedSocialLink, SocialLinkDTO.class);
    }

    @Override
    public SocialLinkDTO getSocialLinkById(Long id) {
        final var socialLink = socialLinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SocialLink", "id", id));
        
        return modelMapper.map(socialLink, SocialLinkDTO.class);
    }

    @Override
    public List<SocialLinkDTO> getAllSocialLinks() {
        return socialLinkRepository
                .findAll()
                .stream()
                .map(socialLink -> modelMapper.map(socialLink, SocialLinkDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SocialLinkDTO updateSocialLink(SocialLinkDTO socialLinkDTO, Long id) {
        final var developer = developerRepository.findById(socialLinkDTO.getDeveloperId())
                .orElseThrow(() -> new ResourceNotFoundException("Developer", "id", socialLinkDTO.getDeveloperId()));
        
        final var social = socialRepository.findById(socialLinkDTO.getSocialId())
                .orElseThrow(() -> new ResourceNotFoundException("Social", "id", socialLinkDTO.getSocialId()));

        final var socialLink = socialLinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SocialLink", "id", id));
        
        socialLink.setAlt(socialLinkDTO.getAlt());
        socialLink.setLink(socialLinkDTO.getLink());
        socialLink.setId(socialLinkDTO.getId());

        socialLink.setDeveloper(developer);
        socialLink.setSocial(social);
        
        final var updatedSocialLink = socialLinkRepository.save(socialLink);

        return modelMapper.map(updatedSocialLink, SocialLinkDTO.class);
    }

    @Override
    public void removeSocialLink(Long id) {
        final var socialLink = socialLinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("socialLink", "id", id));
        
        socialLinkRepository.deleteById(socialLink.getId());
    }
    
}
