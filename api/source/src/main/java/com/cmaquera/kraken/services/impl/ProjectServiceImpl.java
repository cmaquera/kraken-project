package com.cmaquera.kraken.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cmaquera.kraken.configs.ModelMapperConfiguration;
import com.cmaquera.kraken.exceptions.ResourceNotFoundException;
import com.cmaquera.kraken.models.Project;
import com.cmaquera.kraken.payloads.ProjectDTO;
import com.cmaquera.kraken.repositories.CategoryRepository;
import com.cmaquera.kraken.repositories.ClientRepository;
import com.cmaquera.kraken.repositories.DeveloperRepository;
import com.cmaquera.kraken.repositories.ProjectRepository;
import com.cmaquera.kraken.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ModelMapper modelMapper;
    
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    public ProjectServiceImpl() {
        this.modelMapper = new ModelMapperConfiguration().getModelMapper();
    }

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        final var category = categoryRepository.findById(projectDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", projectDTO.getCategoryId()));

        final var client = clientRepository.findById(projectDTO.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", projectDTO.getClientId()));

        final var developer = developerRepository.findById(projectDTO.getDeveloperId())
                .orElseThrow(() -> new ResourceNotFoundException("Developer", "id", projectDTO.getDeveloperId()));

        Project project = modelMapper.map(projectDTO, Project.class);
        project.setCategory(category);
        project.setClient(client);
        project.setDeveloper(developer);        
        
        Project savedProject = projectRepository.save(project);

        return modelMapper.map(savedProject, ProjectDTO.class);

    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository
                .findAll()
                .stream()
                .map(project -> modelMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        final var project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
    
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO, Long id) {
        final var category = categoryRepository.findById(projectDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", projectDTO.getCategoryId()));

        final var client = clientRepository.findById(projectDTO.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", projectDTO.getClientId()));

        final var developer = developerRepository.findById(projectDTO.getDeveloperId())
                .orElseThrow(() -> new ResourceNotFoundException("Developer", "id", projectDTO.getDeveloperId()));

        final var project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
    
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setStatus(projectDTO.getStatus());
        project.setStarDate(projectDTO.getStarDate());
        project.setEndDate(projectDTO.getEndDate());

        project.setCategory(category);
        project.setClient(client);
        project.setDeveloper(developer);

        final var updatedProject = projectRepository.save(project);

        return modelMapper.map(updatedProject, ProjectDTO.class);        
    }

    @Override
    public void removeProject(Long id) {
        final var project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
    
        projectRepository.deleteById(project.getId());
    }

    @Override
    public ProjectDTO getAllProjectWithPagination(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProjectWithPagination'");
    }

    @Override
    public List<ProjectDTO> getProjectBySort(String sortBy, String sortOrder) {
        Sort.Direction direction;
        if (sortOrder.equalsIgnoreCase("ASC"))
            direction = Sort.Direction.ASC;
        else if (sortOrder.equalsIgnoreCase("DESC"))
            direction = Sort.Direction.DESC;
        else
            throw new IllegalArgumentException("Please enter valid sort direction");
        return projectRepository
                .findAll(Sort.by(direction, sortBy))
                .stream()
                .map((project) -> modelMapper.map(project, ProjectDTO.class))
                .toList();
    }
}
