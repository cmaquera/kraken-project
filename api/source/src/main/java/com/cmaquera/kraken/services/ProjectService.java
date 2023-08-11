package com.cmaquera.kraken.services;

import java.util.List;

import com.cmaquera.kraken.payloads.ProjectDTO;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projectDTO);

    List<ProjectDTO> getAllProjects();

    ProjectDTO getProjectById(Long id);

    ProjectDTO updateProject(ProjectDTO postDto, Long id);

    void deleteProject(Long id);

    ProjectDTO getAllProjectWithPagination(int pageNo, int pageSize);

    List<ProjectDTO> getProjectBySort(String sortBy, String sortOrder);
    
}
