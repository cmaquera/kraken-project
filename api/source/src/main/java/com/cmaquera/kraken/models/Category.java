package com.cmaquera.kraken.models;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="category")
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity {
    
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Project> projects;
}
