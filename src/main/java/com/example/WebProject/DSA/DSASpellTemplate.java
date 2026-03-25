package com.example.WebProject.DSA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class DSASpellTemplate {
    
    @Id
    @GeneratedValue
    private Long id;

    @Getter @Setter String name;

    @Getter @Setter String Probe;

    @Getter @Setter int Zd;

    @Getter @Setter private String AsP;

    @Getter @Setter private String Reichweite;

    @Getter @Setter private String Wd;

    @Getter @Setter private String Ziel;
}
