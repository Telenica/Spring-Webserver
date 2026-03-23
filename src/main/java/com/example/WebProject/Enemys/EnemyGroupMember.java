package com.example.WebProject.Enemys;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import java.util.Set;

import com.example.WebProject.Enumzusätze.Status;
import com.example.WebProject.Homebrew.HomeCondition;

import java.util.HashSet;

//Feind in Gruppe
@Entity
public class EnemyGroupMember {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enemy_id")
    private EnemyTemplate enemyTemplate;

    private int currentHP;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection(targetClass = HomeCondition.class)
    @Enumerated(EnumType.STRING)
    private Set<HomeCondition> conditions = new HashSet<>();

    //ID zurückgeben
    public Long getId() { 
        return id; 
    }

    //herausgeben und angeben des Feindes der zur Gruppe dazu soll
    public EnemyTemplate getEnemyTemplate() { 
        return enemyTemplate; 
    }

    public void setEnemyTemplate(EnemyTemplate enemyTemplate) { 
        this.enemyTemplate = enemyTemplate; 
    }

    //herausgeben und angeben der HP des Feindes
    public int getCurrentHP() { 
        return currentHP; 
    }

    public void setCurrentHP(int currentHP) { 
        this.currentHP = Math.max(0, Math.min(currentHP, enemyTemplate.getMaxHP())); 
        updateStatus();
    }

    //Gesundheitslevel herausgeben und berechnen
    public Status getStatus() { 
        return status; 
    }

    private void updateStatus() {
        if (currentHP <= 0) {
            status = Status.BESIEGT;
        } 
        else if (currentHP <= enemyTemplate.getMaxHP() / 2) {
            status = Status.ANGESCHLAGEN;
        } 
        else {
            status = Status.GESUND;
        }
    }

    //Gesundheitszustand anpassen und herausgeben
    public Set<HomeCondition> getConditions() { 
        return conditions; 
    }

    public void addCondition(HomeCondition condition) { 
        conditions.add(condition); 
    }

    public void removeCondition(HomeCondition condition) { 
        conditions.remove(condition); 
    }

}
