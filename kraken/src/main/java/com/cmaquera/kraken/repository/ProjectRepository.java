package com.cmaquera.kraken.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmaquera.kraken.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}