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
    private Date starDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ManyToMany
    @JoinTable(
        name = "project_technology",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private Set<Technology> technologies;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_image_id", referencedColumnName = "id")
    private ProjectImage projectImage;

    

}
