package com.cmaquera.kraken.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="address")
@Getter
@Setter
@NoArgsConstructor
public class Address extends BaseEntity {

    private String country;
    private String state;

    @OneToOne(mappedBy="address")
    private Developer developer;
}