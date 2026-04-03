package com.example.WebProject.DnD;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class DnDSpellTemplate {
    
    @Id
    @GeneratedValue
    private Long id;

    @Getter @Setter private String name;
    @Getter @Setter private int Level;
    @Getter @Setter private String Damage;
    @Getter @Setter private String CastingTime;
    @Getter @Setter private String Range;
    @Getter @Setter private String Duration;
    @Getter @Setter private String Components;
    @Getter @Setter private String HigherLevel;
    @Getter @Setter private List<String> Classes;

    public DnDSpellTemplate(String name, int Level, String Damage, String CastingTime, String Range, String Duration, String Components, String HigherLevel, List<String> Classes){
        this.name = name;
        this.Level = Level;
        this.Damage = Damage;
        this.CastingTime = CastingTime;
        this.Range = Range;
        this.Duration = Duration;
        this.Components = Components;
        this.HigherLevel = HigherLevel;
        this.Classes = Classes;
    }

}
