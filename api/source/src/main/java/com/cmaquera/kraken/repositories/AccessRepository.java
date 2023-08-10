package com.cmaquera.kraken.repositories;

import com.cmaquera.kraken.models.Access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<Access, Long> {
    
}
