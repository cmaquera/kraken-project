package com.cmaquera.kraken.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    
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
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adress adress;

}
