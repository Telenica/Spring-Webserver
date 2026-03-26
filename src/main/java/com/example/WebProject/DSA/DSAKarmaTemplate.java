package com.example.WebProject.DSA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class DSAKarmaTemplate {
    
    @Id
    @GeneratedValue
    private Long id;

    @Getter @Setter String name;

    @Getter @Setter String Probe;

    @Getter @Setter String Dauer;

    @Getter @Setter String KaP;

    @Getter @Setter String Reichweite;

    @Getter @Setter String Wirkungsdauer;

    @Getter @Setter String Ziel;

    public DSAKarmaTemplate(String name, String Probe, String Dauer, String KaP, String Reichweite, String Wirkungsdauer, String Ziel){
        this.name = name;
        this.Probe = Probe;
        this.Dauer = Dauer;
        this.KaP = KaP;
        this.Reichweite = Reichweite;
        this.Wirkungsdauer = Wirkungsdauer;
        this.Ziel = Ziel;
    }
}
