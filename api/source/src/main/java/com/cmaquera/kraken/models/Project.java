package com.cmaquera.kraken.models;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="project")
@Getter
@Setter
@NoArgsConstructor
public class Project extends BaseEntity {
    
    private String name;
    private String description;
    private String status;
    private String category;
    private Date starDate;
    private Date endDate;
    private String client;

    @ManyToMany
    @JoinTable(
        name = "project_technology",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    Set<Technology> technologies;

}
