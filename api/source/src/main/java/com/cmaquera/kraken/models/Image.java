package com.cmaquera.kraken.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="image")
@Getter
@Setter
@NoArgsConstructor
public class Image extends BaseEntity {
    
    private String url;
    private String description;

    @OneToOne(mappedBy="image")
    private Project project;

    @OneToOne(mappedBy="image")
    private Developer developer;

}
