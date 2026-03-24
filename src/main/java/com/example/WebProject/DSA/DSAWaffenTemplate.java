package com.example.WebProject.DSA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class DSAWaffenTemplate {
    
    @Id
    @GeneratedValue
    private Long id;

    @Getter @Setter private String name;

    @Getter @Setter private String damage;

    @Getter @Setter private String loading;

    @Getter @Setter private String AtPaMond;

    @Getter @Setter private String distance;
}
