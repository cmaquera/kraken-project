package com.cmaquera.kraken.models;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="credential")
@Getter
@Setter
@NoArgsConstructor
public class Credential extends BaseEntity {
    private String username;
    private String password;

    @OneToOne(mappedBy="credential")
    private Developer developer;

    @ManyToMany
    @JoinTable(
        name = "credential_role",
        joinColumns = @JoinColumn(name = "credential_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
