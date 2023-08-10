package com.cmaquera.kraken.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmaquera.kraken.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
