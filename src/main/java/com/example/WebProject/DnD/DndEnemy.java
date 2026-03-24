package com.example.WebProject.DnD;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.example.WebProject.Enemys.EnemyTemplate;
import com.example.WebProject.Enumzusätze.Systeme;

@Entity
public class DndEnemy extends EnemyTemplate {

    //Basiswerte
    @Getter @Setter private int Str;
    @Getter @Setter private int Dex;
    @Getter @Setter private int Con;
    @Getter @Setter private int Int;
    @Getter @Setter private int Wis;
    @Getter @Setter private int Cha;
    @Getter @Setter private int Ac;
    @Getter @Setter private int Speed;
    @Getter @Setter private int Ini;
    @Getter @Setter private double Cr;
    private List<DnDWaffenTemplate> Waffen;
    @Getter @Setter private List<DnDDamageType> Resistance;
    @Getter @Setter private List<DnDDamageType> Immunitys;
    @Getter @Setter private List<DnDSense> Senses;
    private List<DnDSpells> Spells; 
    @Getter @Setter private List<DnDAction> Actions;

    public DndEnemy(String species, String subspecies, String biom, int maxHP, Systeme sys, int Str, int Dex, int Con, int Int, int Wis, int Cha, int Ac, int Speed, int Ini, double Cr, List<DnDWaffenTemplate> Waffen,List<DnDDamageType> Resistance, List<DnDDamageType> Immunitys, List<DnDSense> Senses, List<DnDSpells> Spells, List<DnDAction> Actions){
        super(species, subspecies, biom, maxHP, sys);
        this.Str = Str;
        this.Dex = Dex;
        this.Con = Con;
        this.Int = Int;
        this.Wis = Wis;
        this.Cha = Cha;
        this.Ac = Ac;
        this.Speed = Speed;
        this.Ini = Ini;
        this.Cr = Cr;
        this.Waffen = Waffen;
        this.Resistance = Resistance;
        this.Immunitys = Immunitys;
        this.Senses = Senses;
        this.Spells = Spells;
        this.Actions = Actions;
    }

    //Spezielle Getter und Setter
    
    //Waffen
    public List<DnDWaffenTemplate> getWaffen() {
        return Waffen;
    }

    public void setWaffen(List<DnDWaffenTemplate> Waffen) {
        this.Waffen = Waffen;
    }

    public void addWaffe(DnDWaffenTemplate Waffe) {
        this.Waffen.add(Waffe);
    }

    public void removeWaffe(DnDWaffenTemplate Waffe) {
        this.Waffen.remove(Waffe);
    }

    //Spells
    public List<DnDSpells> getSpells() {
        return this.Spells;
    }

    public void setSpells(List<DnDSpells> Spells) {
        this.Spells = Spells;
    }

    public void addSpell(DnDSpells Spell) {
        this.Spells.add(Spell);
    }

    public void removeSpell(DnDSpells Spell) {
        this.Spells.remove(Spell);
    }
}