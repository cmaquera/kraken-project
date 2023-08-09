package com.cmaquera.kraken.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="technology")
@Getter
@Setter
@NoArgsConstructor
public class Technology extends BaseEntity {

    private String name;
    private String description;

    @ManyToMany(mappedBy = "project_technology")
    Set<Project> projects;

}
