package com.cmaquera.kraken.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="social")
@Getter
@Setter
@NoArgsConstructor
public class Social extends BaseEntity {
    
    private String name;

    @OneToMany(mappedBy = "social")
    private Set<SocialLink> socialLinksinks;
}
