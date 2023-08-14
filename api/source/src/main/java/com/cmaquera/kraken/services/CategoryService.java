package com.cmaquera.kraken.services;

import java.util.List;

import com.cmaquera.kraken.payloads.CategoryDTO;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategoryById(Long id);

    List<CategoryDTO> getAllCategories();

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long id);
    
    void removeCategory(Long id);

}
