package com.cmaquera.kraken.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="adress")
@Getter
@Setter
@NoArgsConstructor
public class Adress extends BaseEntity {

    private String country;
    private String state;

    @OneToOne(mappedBy="adress")
    private User user;
}