package com.cmaquera.kraken.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmaquera.kraken.models.SocialLink;

@Repository
public interface SocialLinkRepository extends JpaRepository<SocialLink, Long>{
    
}
