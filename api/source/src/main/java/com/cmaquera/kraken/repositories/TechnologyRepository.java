package com.cmaquera.kraken.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmaquera.kraken.models.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {
    
}
