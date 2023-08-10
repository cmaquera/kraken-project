package com.cmaquera.kraken.models;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Developer")
@Getter
@Setter
@NoArgsConstructor
public class Developer extends BaseEntity {
    
    private String name;
    private String apellido;
    private String nikname;
    private String title;
    @Column(name="short_description")
    private String shortDescription;
    private String description;
    @Column(name="search_work")
    private boolean searchWork;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "access_id", referencedColumnName = "id")
    private Access access;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "developer")
    private Set<SocialLink> socialLinks;

    @OneToMany(mappedBy = "developer")
    private Set<Project> projects;

}
