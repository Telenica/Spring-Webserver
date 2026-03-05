package com.example.WebProject;

import jakarta.persistence.Entity;

@Entity
public class HomeEnemy extends Enemy{
    
    private int attacke;
    private int verteidigung;

    public HomeEnemy(String species, String subspecies, String biom, int maxHP, Systeme sys, int attacke, int verteidigung) {
        super(species, subspecies, biom, maxHP, sys);
        this.attacke = attacke;
        this.verteidigung = verteidigung;
    }

    //Getter und Setter
    //Attacke
    public int getAttacke() {
        return attacke;
    }

    public void setAttacke(int attacke) {
        this.attacke = attacke;
    }

    //Verteidigung
    public int getVerteidigung() {
        return verteidigung;
    }

    public void setVerteidigung(int verteidigung) {
        this.verteidigung = verteidigung;
    }
}
