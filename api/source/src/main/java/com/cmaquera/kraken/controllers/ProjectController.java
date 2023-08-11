package com.cmaquera.kraken.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmaquera.kraken.payloads.ProjectDTO;
import com.cmaquera.kraken.services.ProjectService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("api/project")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "/", consumes = "application/json")
    public ProjectDTO create(@RequestBody ProjectDTO project) {
        return projectService.createProject(project);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ProjectDTO retrieve(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping(value = "/", consumes = "application/json")
    public ProjectDTO update(@RequestBody ProjectDTO project, @PathVariable(name = "id") Long id) {
        return projectService.updateProject(project, id);
    }

    @DeleteMapping(value = "/")
    public String delete(Long id) {
        projectService.deleteProject(id);
        return "Done";
    }

}
