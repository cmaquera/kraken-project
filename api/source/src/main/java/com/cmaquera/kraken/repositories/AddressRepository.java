package com.cmaquera.kraken.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmaquera.kraken.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
