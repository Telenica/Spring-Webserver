package com.example.WebProject.DnD;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class DnDWaffenTemplate {

    @Id
    @GeneratedValue
    private Long id;

    @Getter @Setter private String name;

    @Getter @Setter private String damage;

    @Enumerated(EnumType.STRING)
    @Getter @Setter private DnDDamageType damageType;
    
}
