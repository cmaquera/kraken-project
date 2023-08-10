package com.cmaquera.kraken.models;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="access")
@Getter
@Setter
@NoArgsConstructor
public class Access extends BaseEntity {
    private String username;
    private String password;

    @OneToOne(mappedBy="access")
    private Developer developer;

    @ManyToMany
    @JoinTable(
        name = "access_role",
        joinColumns = @JoinColumn(name = "access_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
