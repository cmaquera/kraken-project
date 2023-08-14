package com.cmaquera.kraken.services;

import java.util.List;

import com.cmaquera.kraken.payloads.SocialLinkDTO;

public interface SocialLinkService {
    
    SocialLinkDTO createSocialLink(SocialLinkDTO socialLinkDTO);

    SocialLinkDTO getSocialLinkById(Long id);

    List<SocialLinkDTO> getAllSocialLinks();

    SocialLinkDTO updateSocialLink(SocialLinkDTO socialLinkDTO, Long id);
    
    void removeSocialLink(Long id);

}
