package com.cmaquera.kraken.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmaquera.kraken.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
