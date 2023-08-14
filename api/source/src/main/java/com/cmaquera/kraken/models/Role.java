package com.cmaquera.kraken.models;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="role")
@Getter
@Setter
@NoArgsConstructor
public class Role extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Credential> credentials;
    
}
