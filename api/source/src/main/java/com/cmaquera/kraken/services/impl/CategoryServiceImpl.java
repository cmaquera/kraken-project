package com.cmaquera.kraken.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.configs.ModelMapperConfiguration;
import com.cmaquera.kraken.exceptions.ResourceNotFoundException;
import com.cmaquera.kraken.models.Category;
import com.cmaquera.kraken.payloads.CategoryDTO;
import com.cmaquera.kraken.repositories.CategoryRepository;
import com.cmaquera.kraken.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CategoryServiceImpl() {
        this.modelMapper = new ModelMapperConfiguration().getModelMapper();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        final var savedCategory = categoryRepository.save(modelMapper.map(categoryDTO, Category.class));

        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        final var category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category", "id", id));
        
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long id) {
        final var category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category", "id", id));
        
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setId(categoryDTO.getId());
        final var updatedCategory = categoryRepository.save(category);

        return modelMapper.map(updatedCategory, CategoryDTO.class);
    }

    @Override
    public void removeCategory(Long id) {
        final var category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category", "id", id));
        
        categoryRepository.deleteById(category.getId());
    }
    
}
