package com.example.WebProject.DSA;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.example.WebProject.Enemys.EnemyTemplate;
import com.example.WebProject.Enumzusätze.Systeme;

@Entity
public class DSAEnemy extends EnemyTemplate{
    
    //Basiswerte
    @Getter @Setter private int MUT;
    @Getter @Setter private int KLUGHEIT;
    @Getter @Setter private int INTUITION;
    @Getter @Setter private int CHARISMA;
    @Getter @Setter private int FINGERFERTIGKEIT;
    @Getter @Setter private int GEWANDTHEIT;
    @Getter @Setter private int KONSTITUTION;
    @Getter @Setter private int KOERPERKRAFT;
    @Getter @Setter private int GESCHWINDIGKEIT;
    @Getter @Setter private int INIBASIS;
    private int ATTACKE;
    private int PARADE;
    @Getter @Setter private int FERNKAMPF;
    @Getter @Setter private int AUSWEICHEN;
    private List<DSAWaffenTemplate> WAFFEN;
    private List<DSASpells> SPELLS;

    public DSAEnemy(String species, String subSpecies, String biom, int maxHP, Systeme sys, int MU, int KL, int IN, int CH, int FF, int GW, int KO, int KK, int GS, int IB, int AT, int PA, int FK, int AW, List<DSAWaffenTemplate> WAFFEN, List<DSASpells> spells){
        super(species, subSpecies, biom, maxHP, sys);
        this.MUT = MU;
        this.KLUGHEIT = KL;
        this.INTUITION = IN;
        this.CHARISMA = CH;
        this.FINGERFERTIGKEIT = FF;
        this.GEWANDTHEIT = GW;
        this.KONSTITUTION = KO;
        this.KOERPERKRAFT = KK;
        this.GESCHWINDIGKEIT = GS;
        this.INIBASIS = IB;
        this.ATTACKE = AT;
        this.PARADE = PA;
        this.FERNKAMPF = FK;
        this.AUSWEICHEN = AW;
        this.WAFFEN = WAFFEN;
        this.SPELLS = spells;
    }

    //Spezielle Getter und Setter

    //Attacke
    public int getAT() {
        return ATTACKE;
    }

    public void setAT(int AT) {
        this.ATTACKE = AT;
    }

    //Parade
    public int getPA() {
        return PARADE;
    }

    public void setPA(int PA) {
        this.PARADE = PA;
    }

    //Waffen
    public List<DSAWaffenTemplate> getWaffen() {
        return WAFFEN;
    }

    public void setWaffen(List<DSAWaffenTemplate> WAFFEN) {
        this.WAFFEN = WAFFEN;
    }

    public void addWaffe(DSAWaffenTemplate Waffe) {
        this.WAFFEN.add(Waffe);
    }

    public void removeWaffe(DSAWaffenTemplate Waffe) {
        this.WAFFEN.remove(Waffe);
    }

    //Spells
    public List<DSASpells> getSpells() {
        return this.SPELLS;
    }

    public void setSpells(List<DSASpells> Spells) {
        this.SPELLS = Spells;
    }

    public void addSpell(DSASpells Spell) {
        this.SPELLS.add(Spell);
    }

    public void removeSpell(DSASpells Spell) {
        this.SPELLS.remove(Spell);
    }
}
