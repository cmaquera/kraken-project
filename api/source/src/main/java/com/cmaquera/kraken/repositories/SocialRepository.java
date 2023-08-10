package com.cmaquera.kraken.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmaquera.kraken.models.Social;


@Repository
public interface SocialRepository extends JpaRepository<Social, Long> {
    
}
