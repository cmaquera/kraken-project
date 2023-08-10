package com.cmaquera.kraken.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="social_link")
@Getter
@Setter
@NoArgsConstructor
public class SocialLink extends BaseEntity {

    private String link;
    private String alt;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ManyToOne
    @JoinColumn(name = "social_id")
    private Social social;

}
    
