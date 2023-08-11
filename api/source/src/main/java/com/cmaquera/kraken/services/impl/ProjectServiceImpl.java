package com.cmaquera.kraken.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.configs.ModelMapperConfiguration;
import com.cmaquera.kraken.exceptions.ResourceNotFoundException;
import com.cmaquera.kraken.models.Project;
import com.cmaquera.kraken.payloads.ProjectDTO;
import com.cmaquera.kraken.repositories.ProjectRepository;
import com.cmaquera.kraken.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ModelMapper modelMapper;
    
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectServiceImpl() {
        this.modelMapper = new ModelMapperConfiguration().getModelMapper();
    }

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {

        Project project = modelMapper.map(projectDTO, Project.class);
        Project savedProject = projectRepository.save(project);
        return modelMapper.map(savedProject, ProjectDTO.class);

    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProjects'");
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
       
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProjectById'");
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO postDto, Long id) {
       
        throw new UnsupportedOperationException("Unimplemented method 'updateProject'");
    }

    @Override
    public void deleteProject(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProject'");
    }

    @Override
    public ProjectDTO getAllProjectWithPagination(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProjectWithPagination'");
    }

    @Override
    public List<ProjectDTO> getProjectBySort(String sortBy, String sortOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProjectBySort'");
    }
}
