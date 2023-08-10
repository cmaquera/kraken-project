package com.cmaquera.kraken.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="project_image")
@Getter
@Setter
@NoArgsConstructor
public class ProjectImage extends BaseEntity {
    
    private String url;
    private String description;

    @OneToOne(mappedBy="projectImage")
    private Project project;

}
