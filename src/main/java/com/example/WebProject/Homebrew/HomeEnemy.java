package com.example.WebProject.Homebrew;

import com.example.WebProject.Enemys.EnemyTemplate;
import com.example.WebProject.Enumzusätze.Systeme;

import jakarta.persistence.Entity;

@Entity
public class HomeEnemy extends EnemyTemplate{
    
    //Basiswerte
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
