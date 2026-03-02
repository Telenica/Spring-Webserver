package com.example.WebProject;

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
import java.util.HashSet;

//Feind in Gruppe
@Entity
public class EnemyGroupMember {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enemy_id")
    private Enemy enemyTemplate;

    private int currentHP;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection(targetClass = Condition.class)
    @Enumerated(EnumType.STRING)
    private Set<Condition> conditions = new HashSet<>();

    //ID zurückgeben
    public Long getId() { 
        return id; 
    }

    //herausgeben und angeben des Feindes der zur Gruppe dazu soll
    public Enemy getEnemyTemplate() { 
        return enemyTemplate; 
    }

    public void setEnemyTemplate(Enemy enemyTemplate) { 
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
        else if (currentHP < enemyTemplate.getMaxHP() / 2) {
            status = Status.ANGESCHLAGEN;
        } 
        else {
            status = Status.GESUND;
        }
    }

    //Gesundheitszustand anpassen und herausgeben
    public Set<Condition> getConditions() { 
        return conditions; 
    }

    public void addCondition(Condition condition) { 
        conditions.add(condition); 
    }

    public void removeCondition(Condition condition) { 
        conditions.remove(condition); 
    }

}
