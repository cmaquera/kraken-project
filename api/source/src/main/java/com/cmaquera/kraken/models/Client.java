package com.cmaquera.kraken.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="client")
@Getter
@Setter
@NoArgsConstructor
public class Client extends BaseEntity {
    
    private String name;
    private String description;
    
    @OneToMany(mappedBy = "client")
    private Set<Project> projects;
}
