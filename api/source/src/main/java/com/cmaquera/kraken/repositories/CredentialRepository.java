package com.cmaquera.kraken.repositories;

import com.cmaquera.kraken.models.Credential;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {
    
}
