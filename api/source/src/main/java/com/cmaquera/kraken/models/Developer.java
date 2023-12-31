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
    private String lastname;
    private String nikname;
    private String title;
    @Column(name="short_description")
    private String shortDescription;
    private String description;
    @Column(name="search_work")
    private boolean searchWork;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credential_id", referencedColumnName = "id")
    private Credential credential;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "developer")
    private Set<SocialLink> socialLinks;

    @OneToMany(mappedBy = "developer")
    private Set<Project> projects;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

}
