package com.cmaquera.kraken.models;

import jakarta.persistence.Entity;
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
}
