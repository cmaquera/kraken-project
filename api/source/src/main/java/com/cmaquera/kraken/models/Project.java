package com.cmaquera.kraken.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="project")
@Getter
@Setter
@NoArgsConstructor
public class Project extends BaseEntity {
    
    private String name;
    private String description;
    private String status;
    private String category;
    private Date starDate;
    private Date endDate;
    private String client;

}
