package com.cmaquera.kraken.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="access")
@Getter
@Setter
@NoArgsConstructor
public class Access extends BaseEntity {
    private String username;
    private String password;

    @OneToOne(mappedBy="access")
    private User user;
}
