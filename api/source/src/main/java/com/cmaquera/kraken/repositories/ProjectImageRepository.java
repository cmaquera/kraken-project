package com.cmaquera.kraken.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmaquera.kraken.models.ProjectImage;

@Repository
public interface ProjectImageRepository extends JpaRepository<ProjectImage, Long> {
    
}
