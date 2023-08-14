package com.cmaquera.kraken.services;

import java.util.List;

import com.cmaquera.kraken.payloads.SocialDTO;

public interface SocialService {
    
    SocialDTO createSocial(SocialDTO socialDTO);

    SocialDTO getSocialById(Long id);

    List<SocialDTO> getAllSocials();

    SocialDTO updateSocial(SocialDTO socialDTO, Long id);
    
    void removeSocial(Long id);

}
