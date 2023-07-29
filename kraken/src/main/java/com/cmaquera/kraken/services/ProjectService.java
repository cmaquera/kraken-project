package com.cmaquera.kraken.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.models.Project;
import com.cmaquera.kraken.repositories.ProjectRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjectService implements BaseService<Project> {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project create(Project entity) {
        return projectRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project retrieve(Long id) {        
        return projectRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Project with id: " + id + ", not available.")
        );
    }

    @Override
    public Project update(Project entity) {
        Project project = projectRepository.findById(entity.getId()).orElseThrow(
            () -> new EntityNotFoundException("Project with id: " + entity.getId() + ", not available.")
        );
        
        project.setName(entity.getName());
        project.setDescription(entity.getDescription());
        project.setStatus(entity.getStatus());
        project.setCategory(entity.getCategory());
        project.setStarDate(entity.getStarDate());
        project.setEndDate(entity.getEndDate());
        project.setClient(entity.getClient());

        return projectRepository.save(project);

    }
    
}
